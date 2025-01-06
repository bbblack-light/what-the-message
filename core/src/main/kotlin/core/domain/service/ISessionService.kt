package core.domain.service

import core.domain.model.player.PlayerModel
import core.domain.model.session.CreateSessionRequestModel
import core.domain.model.session.SessionModel
import core.domain.model.session.AddPlayerToSessionRequestModel
import core.domain.model.session.StartGameRequestModel

interface ISessionService {
    fun createSession(request: CreateSessionRequestModel): SessionModel
    fun addPlayerToSession(request: AddPlayerToSessionRequestModel)
    fun getSessionPlayers(sessionId: String): List<PlayerModel>
    fun startGame(request: StartGameRequestModel)
}