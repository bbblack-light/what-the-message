package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.player.PlayerModel

interface IWtmGameSessionManager {
    fun addSession(
        players: List<PlayerModel>,
        cardsOut: List<SmsCard>,
        cardsIn: List<SmsCard>,
        sessionId: String
    )
    fun startRound(sessionId: String)
    fun playerChooseCard(sessionId: String, playerId: String, cardId: String)
    fun playerVoteCard(sessionId: String, playerId: String, cardId: String)
    fun playerGetCardFromStack(sessionId: String, playerId: String)
}