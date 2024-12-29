package core.domain.service

import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.model.player.CreatePlayerModel
import core.domain.model.player.PlayerModel

internal class PlayerService(
    private val playerStorageAdapter: PlayerStorageAdapter
) : IPlayerService {
    override fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel {
        return playerStorageAdapter.createPlayer(createPlayerModel)
    }

    override fun getPlayers(): List<PlayerModel> {
        return playerStorageAdapter.getPlayers()
    }
}