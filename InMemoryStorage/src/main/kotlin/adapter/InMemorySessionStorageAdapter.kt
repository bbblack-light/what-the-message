package storage.inmemory.adapter

import com.service.wtm.core.domain.model.session.CreateSessionModel
import com.service.wtm.core.domain.model.session.SessionModel
import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.storageAdapter.SessionStorageAdapter
import storage.inmemory.entity.SessionEntity
import storage.inmemory.mapper.toModel
import storage.inmemory.mapper.toPlayerEntity
import storage.inmemory.mapper.toSessionEntity
import java.util.UUID

internal class InMemorySessionStorageAdapter(
    private val playerStorageAdapter: PlayerStorageAdapter,
    private val sessions: MutableCollection<SessionEntity> = mutableListOf()
) : SessionStorageAdapter {
    override fun createSession(createSessionModel: CreateSessionModel): SessionModel {
        val player = playerStorageAdapter.getPlayer(UUID.fromString(createSessionModel.ownerUuid))

        val entity = createSessionModel.toSessionEntity(player.toPlayerEntity())
        sessions.add(entity)

        return entity.toModel()
    }
}