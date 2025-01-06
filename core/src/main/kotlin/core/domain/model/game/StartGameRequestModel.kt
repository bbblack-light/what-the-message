package core.domain.model.game

import core.domain.model.player.PlayerModel

data class StartGameRequestModel(
    val players: List<PlayerModel>,
    val sessionId: String
)