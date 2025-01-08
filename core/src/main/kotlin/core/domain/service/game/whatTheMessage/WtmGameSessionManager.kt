package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.player.PlayerModel
import core.domain.service.game.whatTheMessage.notification.IWtmNotifier
import core.domain.service.game.whatTheMessage.gameCore.models.WtmPlayerModel
import core.domain.service.game.whatTheMessage.gameCore.WtmSessionViewModel
import java.util.LinkedList
import java.util.Queue

internal class WtmGameSessionManager(
    private val notifier: IWtmNotifier
) : IWtmGameSessionManager {
    private val sessions: MutableCollection<WtmSessionViewModel> = mutableListOf()
    override fun addSession(
        players: List<PlayerModel>,
        cardsOut: List<SmsCard>,
        cardsIn: List<SmsCard>,
        sessionId: String
    ) {
        val cardsInQueue: Queue<SmsCard> = LinkedList(cardsIn.shuffled())
        val cardsOutQueue: Queue<SmsCard> = LinkedList(cardsIn.shuffled())

        val session = WtmSessionViewModel(
            players = players.map {
                WtmPlayerModel(it.id, getStartPlayerCardsFromQueue(cardsInQueue))
            }.toMutableList(),
            cardsIn = cardsInQueue,
            cardsOut = cardsOutQueue,
            sessionId = sessionId
        )
        session.subscribeOnChanges { notifier.notifyPlayers(it) }
        sessions.add(session)
    }

    private fun getStartPlayerCardsFromQueue(cardsQueue: Queue<SmsCard>): MutableList<SmsCard> {
        val cards: MutableList<SmsCard> = mutableListOf()
        for (i in 0..5) {
            cards.add(cardsQueue.poll())
        }
        return cards
    }

    override fun startRound(sessionId: String) {
        getSession(sessionId).newRound()
    }

    override fun playerChooseCard(sessionId: String, playerId: String, cardId: String) {
        getSession(sessionId).playerChooseCard(playerId, cardId)
    }

    override fun playerVoteCard(sessionId: String, playerId: String, cardId: String) {
        getSession(sessionId).playerVoteCard(playerId, cardId)
    }

    override fun playerGetCardFromStack(sessionId: String, playerId: String) {
        getSession(sessionId).playerGetCardFromStack(playerId)
    }

    private fun getSession(sessionId: String): WtmSessionViewModel {
        return sessions.find { it.sessionId == sessionId }
            ?: throw NullPointerException("Session not found")
    }
}