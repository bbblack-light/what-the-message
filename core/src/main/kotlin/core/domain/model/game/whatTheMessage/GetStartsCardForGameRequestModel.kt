package core.domain.model.game.whatTheMessage

import core.domain.model.player.PlayerModel

data class GetStartsCardForGameRequestModel(
    val players: List<PlayerModel>
)