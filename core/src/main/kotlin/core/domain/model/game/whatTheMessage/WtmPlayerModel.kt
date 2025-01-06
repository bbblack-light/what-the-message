package core.domain.model.game.whatTheMessage

import core.domain.model.player.PlayerModel
import core.domain.model.session.ISessionPlayerModel

internal data class WtmPlayerModel(
    override val playerEntity: PlayerModel,
) : ISessionPlayerModel