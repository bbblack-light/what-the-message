package core.domain.service.game.whatTheMessage.gameCore

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.service.game.whatTheMessage.gameCore.models.GameStatus
import core.domain.service.game.whatTheMessage.gameCore.models.PlayerChooseCardSubscribeInfo
import core.domain.service.game.whatTheMessage.gameCore.models.PlayerGetCardInfo
import core.domain.service.game.whatTheMessage.gameCore.models.PlayerVotedSubscribeInfo
import core.domain.service.game.whatTheMessage.gameCore.models.RoundStartedSubscribeInfo
import core.domain.service.game.whatTheMessage.gameCore.models.StartCheckingResultInfo
import core.domain.service.game.whatTheMessage.gameCore.models.VotingStartedSubscribeInfo
import core.domain.service.game.whatTheMessage.gameCore.models.WtmPlayerModel
import core.domain.service.game.whatTheMessage.gameCore.models.WtmPlayerStatus
import core.domain.service.game.whatTheMessage.gameCore.models.WtmRoundModel
import core.domain.service.game.whatTheMessage.gameCore.models.WtmSubscribeInfo
import java.util.Queue
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class WtmSessionViewModel(
    val sessionId: String,
    private val players: MutableList<WtmPlayerModel>,
    private val cardsIn: Queue<SmsCard>,
    private val cardsOut: Queue<SmsCard>,
) {
    private var gameStatus: GameStatus = GameStatus.READY_TO_ROUND
    private var round: WtmRoundModel? = null
    private val actions: MutableList<(data: WtmSubscribeInfo) -> Unit> = mutableListOf()

    fun subscribeOnChanges(action: (data: WtmSubscribeInfo) -> Unit) {
        actions.add(action)
    }

    fun newRound() {
        round = WtmRoundModel(cardsIn.poll())
        players.forEach { it.status = WtmPlayerStatus.CHOOSING_CARD }
        gameStatus = GameStatus.PLAYERS_CHOOSING_CARDS
        notifySubscribersAboutChanges(
            RoundStartedSubscribeInfo(
                sessionId = sessionId,
                status = gameStatus,
                playersIds = players.map { it.playerId }.toList(),
                inputCard = round!!.inCard
            )
        )
    }

    fun playerChooseCard(playerId: String, cardId: String) {
        roundRunningCheck()

        val player =
            players.find { it.playerId == playerId }
                ?: throw NullPointerException("Player not found in this session")

        val card = player.getCardFromHand(cardId)
        round!!.addCard(card)
        player.status = WtmPlayerStatus.READY_TO_VOTING

        notifySubscribersAboutChanges(
            PlayerChooseCardSubscribeInfo(
                sessionId = sessionId,
                status = gameStatus,
                playersIds = players.map { it.playerId }.toList(),
                playerIdThatChooseCard = player.playerId
            )
        )

        if (matchPlayersStatus(WtmPlayerStatus.READY_TO_VOTING)) {
            startVoting()
        }
    }

    fun playerVoteCard(playerId: String, cardId: String) {
        roundRunningCheck()

        val player =
            players.find { it.playerId == playerId }
                ?: throw NullPointerException("Player not found in this session")

        player.status = WtmPlayerStatus.VOTED
        round!!.voteCard(cardId)

        notifySubscribersAboutChanges(
            PlayerVotedSubscribeInfo(
                sessionId = sessionId,
                status = gameStatus,
                playersIds = players.map { it.playerId }.toList(),
                votedPlayer = player.playerId
            )
        )

        if (matchPlayersStatus(WtmPlayerStatus.VOTED)) {
            checkingResults()
        }
    }

    fun playerGetCardFromStack(playerId: String) {
        val player = players.find { it.playerId == playerId }
            ?: throw NullPointerException("Player not found in this session")

        val card = cardsOut.poll()
        player.addCard(card)

        notifySubscribersAboutChanges(
            PlayerGetCardInfo(
                sessionId = sessionId,
                status = gameStatus,
                playersIds = players.map { it.playerId }.toList(),
                playerId = player.playerId,
                card = card
            )
        )
    }

    private fun roundRunningCheck() {
        if (round == null) {
            throw NullPointerException("Round not started")
        }
    }

    private fun startVoting() {
        roundRunningCheck()

        players.forEach { it.status = WtmPlayerStatus.VOTING }
        gameStatus = GameStatus.VOTING

        notifySubscribersAboutChanges(
            VotingStartedSubscribeInfo(
                sessionId = sessionId,
                status = gameStatus,
                playersIds = players.map { it.playerId }.toList(),
                cardsToVote = round!!.getCardsForVoting()
            )
        )
    }

    private fun matchPlayersStatus(playerStatus: WtmPlayerStatus): Boolean {
        return players.all { it.status == playerStatus }
    }

    private fun checkingResults() {
        roundRunningCheck()
        val roundWinnerCardWithPlayerId = round!!.getMaxVotedCountCardWithPlayer()
        val winnerPlayer = players.find { it.playerId == roundWinnerCardWithPlayerId.playerId }

        winnerPlayer?.incrementWinningCount()
        gameStatus = GameStatus.CHECKING_RESULTS

        notifySubscribersAboutChanges(
            StartCheckingResultInfo(
                sessionId = sessionId,
                status = gameStatus,
                playersIds = players.map { it.playerId }.toList(),
                winnerPlayerId = winnerPlayer!!.playerId,
                winnerCard = roundWinnerCardWithPlayerId.card
            )
        )

        //TODO: check this deprecated method
        GlobalScope.launch { // launch a new coroutine and continue
            readyForNewRound()
        }
    }

    private suspend fun readyForNewRound() {
        delay(5000)
        players.forEach { it.status = WtmPlayerStatus.READY }
        gameStatus = GameStatus.READY_TO_ROUND
    }

    private fun notifySubscribersAboutChanges(data: WtmSubscribeInfo) {
        actions.forEach { it.invoke(data) }
    }
}