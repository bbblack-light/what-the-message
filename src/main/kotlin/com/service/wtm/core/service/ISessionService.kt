package com.service.wtm.core.service

import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel

interface ISessionService {
    fun createSession(createSessionModel: CreateSessionModel): SessionModel
}