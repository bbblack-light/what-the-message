package core.domain.service

import core.domain.storageAdapter.SessionStorageAdapter
import com.service.wtm.core.domain.model.session.CreateSessionModel
import com.service.wtm.core.domain.model.session.SessionModel

internal class SessionService(
    private val gameSessionStorageAdapter: SessionStorageAdapter,
): ISessionService {
    override fun createSession(createSessionModel: CreateSessionModel): SessionModel {
        return gameSessionStorageAdapter.createSession(createSessionModel)
    }
}