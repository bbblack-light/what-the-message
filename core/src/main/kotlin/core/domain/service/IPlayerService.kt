package core.domain.service

import core.domain.model.player.CreatePlayerModel
import core.domain.model.player.PlayerModel

interface IPlayerService {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel

    fun getPlayers(): List<PlayerModel>
}