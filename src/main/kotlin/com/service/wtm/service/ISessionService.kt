package com.service.wtm.service

import com.service.wtm.model.GameSessionModel

interface ISessionService {
    fun createSession(): GameSessionModel
}