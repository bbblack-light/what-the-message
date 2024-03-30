package com.service.wtm.core.service

import com.service.wtm.core.domain.CreateGameSessionModel

interface ISessionService {
    fun createSession(): CreateGameSessionModel
}