package core.domain.service

import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.model.player.CreatePlayerRequestModel
import core.domain.model.player.PlayerModel

internal class PlayerService(
    private val playerStorageAdapter: PlayerStorageAdapter
) : IPlayerService {
    override fun createPlayer(request: CreatePlayerRequestModel): PlayerModel {
        return playerStorageAdapter.createPlayer(request)
    }

    override fun getPlayers(): List<PlayerModel> {
        return playerStorageAdapter.getPlayers()
    }

    override fun getPlayer(id: String): PlayerModel {
        return playerStorageAdapter.getPlayer(id)
    }
}