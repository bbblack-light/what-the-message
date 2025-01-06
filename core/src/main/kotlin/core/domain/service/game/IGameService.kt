package core.domain.service.game

import core.domain.model.ModelGameType
import core.domain.model.game.StartGameRequestModel

interface IGameService {
    fun startGame(request: StartGameRequestModel)
    fun game(): ModelGameType
}