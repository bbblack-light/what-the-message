package com.service.wtm.core.domain.session

import com.service.wtm.core.domain.player.PlayerModel

data class SessionModel (
    val uuid: String,
    val owner: PlayerModel,
)