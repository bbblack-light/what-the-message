package core.domain.service

import core.domain.model.player.CreatePlayerRequestModel
import core.domain.model.player.PlayerModel

interface IPlayerService {
    fun createPlayer(request: CreatePlayerRequestModel): PlayerModel

    fun getPlayers(): List<PlayerModel>

    fun getPlayer(id: String): PlayerModel
}