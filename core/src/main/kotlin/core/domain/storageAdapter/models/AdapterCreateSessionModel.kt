package core.domain.storageAdapter.models

import core.domain.model.ModelGameType
import core.domain.model.player.PlayerModel

data class AdapterCreateSessionModel (
    val gameType: ModelGameType,
    val ownerId: String
)