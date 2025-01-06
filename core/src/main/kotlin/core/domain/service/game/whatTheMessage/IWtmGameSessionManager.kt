package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.PlayerCards
import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.service.game.whatTheMessage.session.WtmSessionModel

interface IWtmGameSessionManager {
    fun addSession(
        players: List<PlayerCards>,
        cardsOut: List<SmsCard>,
        cardsIn: List<SmsCard>,
        sessionId: String
    )
    fun getSessionState(sessionId: String): WtmSessionModel
}