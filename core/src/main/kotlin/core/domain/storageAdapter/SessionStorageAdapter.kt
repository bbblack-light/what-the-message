package core.domain.storageAdapter

import com.service.wtm.core.domain.model.session.CreateSessionModel
import com.service.wtm.core.domain.model.session.SessionModel

interface SessionStorageAdapter {
    fun createSession(createSessionModel: CreateSessionModel): SessionModel
}