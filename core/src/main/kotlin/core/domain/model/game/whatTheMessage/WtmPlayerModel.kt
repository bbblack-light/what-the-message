package core.domain.model.game.whatTheMessage

import core.domain.model.player.PlayerModel

data class WtmPlayerModel(
    val player: PlayerModel,
    val cards: MutableCollection<SmsCard>
)