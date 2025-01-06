package storage.inmemory.adapter

import core.domain.model.session.SessionModel
import core.domain.storageAdapter.SessionStorageAdapter
import core.domain.storageAdapter.models.AdapterCreateSessionModel
import storage.inmemory.entity.SessionEntity
import storage.inmemory.exceptions.NotFoundException
import storage.inmemory.mapper.toModel
import storage.inmemory.mapper.toSessionEntity
import java.util.UUID

internal class InMemorySessionStorageAdapter : SessionStorageAdapter {
    private val sessions: MutableCollection<SessionEntity> = mutableListOf()

    override fun createSession(adapterCreateSessionModel: AdapterCreateSessionModel): SessionModel {
        val entity = adapterCreateSessionModel.toSessionEntity()
        sessions.add(entity)

        return entity.toModel()
    }

    override fun addPlayerToSession(sessionId: String, playerId: String) {
        val sessionUid = UUID.fromString(sessionId)
        val playerUid =  UUID.fromString(playerId)

        val session = sessions.find { it.uuid == sessionUid } ?: throw NotFoundException("session not found")
        session.playersId.add(playerUid)
    }

    override fun existsBySessionIdAndPlayerId(sessionId: String, playerId: String): Boolean {
        val sessionUid = UUID.fromString(sessionId)
        val playerUid =  UUID.fromString(playerId)

        return sessions.any { session ->
            session.uuid == sessionUid &&
            session.playersId.any { player -> player == playerUid }
        }
    }

    override fun getSessionById(sessionId: String): SessionModel {
        val sessionUid = UUID.fromString(sessionId)

        return sessions.find { it.uuid == sessionUid }?.toModel() ?:
        throw NotFoundException("session not found")
    }
}