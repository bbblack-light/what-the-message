package com.service.wtm.integration.storage.inmemory.adapter

import com.service.wtm.core.storageAdapter.SessionStorageAdapter
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.core.storageAdapter.PlayerStorageAdapter
import com.service.wtm.integration.storage.inmemory.entity.SessionEntity
import com.service.wtm.integration.storage.inmemory.mapper.toModel
import com.service.wtm.integration.storage.inmemory.mapper.toPlayerEntity
import com.service.wtm.integration.storage.inmemory.mapper.toSessionEntity
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class InMemorySessionStorageAdapter(
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