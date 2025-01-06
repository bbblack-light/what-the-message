package core.factory

import core.domain.service.IPlayerService
import core.domain.service.ISessionService
import core.domain.service.PlayerService
import core.domain.service.SessionService
import core.domain.service.game.whatTheMessage.CardService
import core.domain.service.game.whatTheMessage.ICardService

open class DomainServiceFactory(
    private val storageAdapterFactory: StorageAdapterFactory
) {
    private var playerService: IPlayerService? = null
    private var sessionService: ISessionService? = null
    private var wtmCardService: ICardService? = null

    open fun playerService(): IPlayerService {
        if (playerService == null) {
            playerService = PlayerService(storageAdapterFactory.playerStorageAdapter())
        }
        return playerService as IPlayerService
    }

    open fun sessionService(): ISessionService {
        if (sessionService == null) {
            sessionService = SessionService(
                storageAdapterFactory.sessionStorageAdapter(),
                playerService()
            )
        }
        return sessionService as ISessionService
    }

    open fun wtmCardService(): ICardService {
        if (wtmCardService == null) {
            wtmCardService = CardService(storageAdapterFactory.wtmSmsCardStorageAdapter())
        }
        return wtmCardService as ICardService
    }
}