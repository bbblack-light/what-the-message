package core.domain.model.game.whatTheMessage

import core.domain.model.player.PlayerModel

internal data class StartWtmGameRequestModel(
    val players: List<PlayerModel>,
    val sessionId: String
)