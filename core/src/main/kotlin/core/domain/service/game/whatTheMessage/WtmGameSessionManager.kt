package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.PlayerCards
import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.WtmPlayerModel
import core.domain.service.game.whatTheMessage.session.WtmSession
import core.domain.service.game.whatTheMessage.session.WtmSessionModel

internal class WtmGameSessionManager: IWtmGameSessionManager {
    private val sessions: MutableCollection<WtmSession> = mutableListOf()
    override fun addSession(
        players: List<PlayerCards>,
        cardsOut: List<SmsCard>,
        cardsIn: List<SmsCard>,
        sessionId: String
    ) {
        sessions.add(WtmSession(
            WtmSessionModel(
                players = players.map{
                    WtmPlayerModel(it.player, it.cards.toMutableList())
                }.toMutableList(),
                cardsIn = cardsIn.toMutableList(),
                cardsOut = cardsOut.toMutableList(),
                sessionId = sessionId
            )
        ))
    }

    override fun getSessionState(sessionId: String): WtmSessionModel {
        return sessions.find { it.model.sessionId == sessionId }?.model ?: throw NullPointerException("not found")
    }
}