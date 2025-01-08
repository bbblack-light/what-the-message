package core.domain.service.game.whatTheMessage.gameCore.models

import core.domain.model.game.whatTheMessage.SmsCard

enum class GameActions {
    ROUND_STARTED,
    PLAYERS_CHOOSE_CARDS,
    VOTING_STARTED,
    PLAYER_VOTED,
    START_CHECKING_RESULTS,
    PLAYER_GET_CARD
}

sealed class WtmSubscribeInfo(
    val action: GameActions,
    val sessionId: String,
    val status: GameStatus,
    val playersIds: List<String>
)

class RoundStartedSubscribeInfo(
    sessionId: String,
    status: GameStatus,
    playersIds: List<String>,
    val inputCard: SmsCard
) : WtmSubscribeInfo(GameActions.ROUND_STARTED, sessionId, status, playersIds)

class PlayerChooseCardSubscribeInfo(
    sessionId: String,
    status: GameStatus,
    playersIds: List<String>,
    val playerIdThatChooseCard: String
) : WtmSubscribeInfo(GameActions.PLAYERS_CHOOSE_CARDS, sessionId, status, playersIds)

class VotingStartedSubscribeInfo(
    sessionId: String,
    status: GameStatus,
    playersIds: List<String>,
    val cardsToVote: List<SmsCard>
) : WtmSubscribeInfo(GameActions.VOTING_STARTED, sessionId, status, playersIds)

class PlayerVotedSubscribeInfo(
    sessionId: String,
    status: GameStatus,
    playersIds: List<String>,
    val votedPlayer: String
) : WtmSubscribeInfo(GameActions.PLAYER_VOTED, sessionId, status, playersIds)

class PlayerGetCardInfo(
    sessionId: String,
    status: GameStatus,
    playersIds: List<String>,
    val playerId: String,
    val card: SmsCard
) : WtmSubscribeInfo(GameActions.PLAYER_GET_CARD, sessionId, status, playersIds)

class StartCheckingResultInfo(
    sessionId: String,
    status: GameStatus,
    playersIds: List<String>,
    val winnerCard: SmsCard,
    val winnerPlayerId: String,
) : WtmSubscribeInfo(GameActions.START_CHECKING_RESULTS, sessionId, status, playersIds)