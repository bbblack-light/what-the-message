package com.service.wtm.core.service.impl

import com.service.wtm.core.storageAdapter.SessionStorageAdapter
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.core.service.ISessionService
import org.springframework.stereotype.Service

@Service
class SessionService(
    private val gameSessionStorageAdapter: SessionStorageAdapter,
): ISessionService {
    override fun createSession(createSessionModel: CreateSessionModel): SessionModel {
        return gameSessionStorageAdapter.createSession(createSessionModel)
    }
}