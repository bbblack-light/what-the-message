package com.service.wtm.mapper

import com.service.wtm.db.entity.Player
import com.service.wtm.model.PlayerModel

fun Player.toModel() =
    PlayerModel(
        uuid = uuid.toString(),
        name = name
    )