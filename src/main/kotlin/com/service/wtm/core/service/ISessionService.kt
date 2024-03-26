package com.service.wtm.core.service

import com.service.wtm.core.domain.GameSessionModel

interface ISessionService {
    fun createSession(): GameSessionModel
}