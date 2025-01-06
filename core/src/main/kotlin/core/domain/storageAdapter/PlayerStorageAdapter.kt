package core.domain.storageAdapter

import core.domain.model.player.CreatePlayerRequestModel
import core.domain.model.player.PlayerModel

interface PlayerStorageAdapter {
    fun createPlayer(request: CreatePlayerRequestModel): PlayerModel
    fun getPlayer(id: String): PlayerModel
    fun getPlayers(): List<PlayerModel>
}