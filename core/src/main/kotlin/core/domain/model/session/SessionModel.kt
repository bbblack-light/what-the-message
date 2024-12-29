package com.service.wtm.core.domain.model.session

import core.domain.model.player.PlayerModel

data class SessionModel (
    val uuid: String,
    val owner: PlayerModel,
)