package core.domain.service

import com.service.wtm.core.domain.model.session.CreateSessionModel
import com.service.wtm.core.domain.model.session.SessionModel

interface ISessionService {
    fun createSession(createSessionModel: CreateSessionModel): SessionModel
}