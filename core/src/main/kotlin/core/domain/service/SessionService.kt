package core.domain.service

import core.domain.exceptions.IllegalException
import core.domain.model.ModelGameType
import core.domain.model.game.StartGameRequestModel
import core.domain.model.player.PlayerModel
import core.domain.storageAdapter.SessionStorageAdapter
import core.domain.model.session.CreateSessionRequestModel
import core.domain.model.session.SessionModel
import core.domain.model.session.AddPlayerToSessionRequestModel
import core.domain.model.session.StartSessionRequestModel
import core.domain.service.game.IGameService
import core.domain.storageAdapter.models.AdapterCreateSessionModel

internal class SessionService(
    private val gameSessionStorageAdapter: SessionStorageAdapter,
    private val playerService: IPlayerService,
    gameServices: List<IGameService>
) : ISessionService {

    private val gameServicesMap: Map<ModelGameType, IGameService> =
        gameServices.associateBy({ it.game() }, { it })

    override fun createSession(request: CreateSessionRequestModel): SessionModel {
        val player = playerService.getPlayer(request.ownerUuid)
        return gameSessionStorageAdapter.createSession(
            AdapterCreateSessionModel(
                ownerId = player.id,
                gameType = request.gameType
            )
        )
    }

    override fun addPlayerToSession(request: AddPlayerToSessionRequestModel) {
        val player = playerService.getPlayer(request.playerId)
        val doesPlayerAlreadyInSession =
            gameSessionStorageAdapter.existsBySessionIdAndPlayerId(request.sessionId, request.playerId)
        if (doesPlayerAlreadyInSession) {
            throw IllegalException("Player already in session")
        }
        gameSessionStorageAdapter.addPlayerToSession(request.sessionId, player.id)
    }

    override fun getSessionPlayers(sessionId: String): List<PlayerModel> {
        val session = gameSessionStorageAdapter.getSessionById(sessionId)
        return session.playersId.map {
            playerService.getPlayer(it)
        }
    }

    override fun startGame(request: StartSessionRequestModel) {
        val session = gameSessionStorageAdapter.getSessionById(request.sessionId)

        val game = gameServicesMap[session.game] ?: throw NotImplementedError("Game is not implemented")

        game.startGame(
            StartGameRequestModel(
                sessionId = session.id,
                players = getSessionPlayers(session.id)
            )
        )
    }
}