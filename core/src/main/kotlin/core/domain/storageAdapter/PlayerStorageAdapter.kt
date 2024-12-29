package core.domain.storageAdapter

import core.domain.model.player.CreatePlayerModel
import core.domain.model.player.PlayerModel
import java.util.UUID

interface PlayerStorageAdapter {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel
    fun getPlayer(uuid: UUID): PlayerModel
    fun getPlayers(): List<PlayerModel>
}