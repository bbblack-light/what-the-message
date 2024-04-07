package com.service.wtm.service.impl

import com.service.wtm.core.adapter.PlayerAdapter
import com.service.wtm.core.adapter.SessionAdapter
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.core.service.ISessionService
import org.springframework.stereotype.Service
import java.util.*

@Service
class SessionService(
    private val gameSessionAdapter: SessionAdapter,
    private val playerAdapter: PlayerAdapter
): ISessionService {
    override fun createSession(createSessionModel: CreateSessionModel): SessionModel {
        val owner = playerAdapter.getPlayer(UUID.fromString(createSessionModel.ownerUuid))
        return gameSessionAdapter.createSession(createSessionModel)
    }

}