package com.service.wtm.core.storageAdapter

import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel

interface SessionStorageAdapter {
    fun createSession(createSessionModel: CreateSessionModel): SessionModel
}