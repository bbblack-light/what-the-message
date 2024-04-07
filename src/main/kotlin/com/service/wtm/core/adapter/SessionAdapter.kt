package com.service.wtm.core.adapter

import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel

interface SessionAdapter {
    fun createSession(createSessionModel: CreateSessionModel): SessionModel
}