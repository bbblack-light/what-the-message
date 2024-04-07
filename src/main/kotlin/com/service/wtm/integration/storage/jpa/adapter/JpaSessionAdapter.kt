package com.service.wtm.integration.storage.jpa.adapter

import com.service.wtm.core.adapter.SessionAdapter
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.integration.storage.entity.SessionEntity
import com.service.wtm.integration.storage.jpa.PlayerRepository
import com.service.wtm.integration.storage.jpa.SessionRepository
import com.service.wtm.integration.storage.toModel
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JpaSessionAdapter(
    private val sessionRepository: SessionRepository,
    private val playerRepository: PlayerRepository
) : SessionAdapter {
    override fun createSession(createSessionModel: CreateSessionModel): SessionModel {
        val player = playerRepository.findById(UUID.fromString(createSessionModel.ownerUuid))
        if (player.isEmpty) throw IllegalArgumentException("player not found")
        val session = SessionEntity(
            player = player.get()
        )
        return sessionRepository.save(session).toModel()
    }
}