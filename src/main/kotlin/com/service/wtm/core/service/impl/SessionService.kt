package com.service.wtm.core.service.impl

import com.service.wtm.core.adapter.SessionAdapter
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.core.service.ISessionService
import org.springframework.stereotype.Service

@Service
class SessionService(
    private val gameSessionAdapter: SessionAdapter,
): ISessionService {
    override fun createSession(createSessionModel: CreateSessionModel): SessionModel {
        return gameSessionAdapter.createSession(createSessionModel)
    }
}