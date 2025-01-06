package core.domain.storageAdapter

import core.domain.model.session.SessionModel
import core.domain.storageAdapter.models.AdapterCreateSessionModel

interface SessionStorageAdapter {
    fun createSession(adapterCreateSessionModel: AdapterCreateSessionModel): SessionModel
    fun addPlayerToSession(sessionId: String, playerId: String)
    fun existsBySessionIdAndPlayerId(sessionId: String, playerId: String): Boolean
    fun getSessionById(sessionId: String): SessionModel
}