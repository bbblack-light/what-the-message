package core.factory

import core.domain.service.IPlayerService
import core.domain.service.ISessionService
import core.domain.service.PlayerService
import core.domain.service.SessionService
import core.domain.service.game.IGameService
import core.domain.service.game.whatTheMessage.CardService
import core.domain.service.game.whatTheMessage.ICardService
import core.domain.service.game.whatTheMessage.IWtmGameSessionManager
import core.domain.service.game.whatTheMessage.WtmGameService
import core.domain.service.game.whatTheMessage.WtmGameSessionManager
import core.domain.service.game.whatTheMessage.notification.WtmNotifier

open class DomainServiceFactory(
    private val storageAdapterFactory: StorageAdapterFactory,
    private val wtmAdapterFactory: GameAdaptersFactory
) {
    private var playerService: IPlayerService? = null
    private var sessionService: ISessionService? = null
    private var wtmCardService: ICardService? = null
    private var wtmGameService: IGameService? = null
    private var wtmGameSessionManager: IWtmGameSessionManager? = null

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
                playerService(),
                listOf(wtmGameService())
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

    open fun wtmGameSessionManager(): IWtmGameSessionManager {
        if (wtmGameSessionManager == null) {
            wtmGameSessionManager = WtmGameSessionManager(
                WtmNotifier(
                    wtmAdapterFactory.WtmNotifyChannel()
                )
            )
        }
        return wtmGameSessionManager as IWtmGameSessionManager
    }

    open fun wtmGameService(): IGameService {
        if (wtmGameService == null) {
            wtmGameService = WtmGameService(
                wtmCardService(),
                wtmGameSessionManager()
            )
        }
        return wtmGameService as IGameService
    }
}