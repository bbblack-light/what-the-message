package core.factory

import core.domain.service.IPlayerService
import core.domain.service.ISessionService
import core.domain.service.PlayerService

open class DomainServiceFactory(
    private val storageAdapterFactory: StorageAdapterFactory
) {
    private var playerService: IPlayerService? = null
    private var sessionService: ISessionService? = null
    open fun playerService(): IPlayerService {
        if (playerService == null) {
            playerService = PlayerService(storageAdapterFactory.playerStorageAdapterFactory())
        }
        return playerService as IPlayerService
    }

    open fun SessionService(): ISessionService {
        if (sessionService == null) {
            sessionService =
                core.domain.service.SessionService(storageAdapterFactory.sessionStorageAdapterFactory())
        }
        return sessionService as ISessionService
    }
}