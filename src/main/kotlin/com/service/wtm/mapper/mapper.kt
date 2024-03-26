package com.service.wtm.mapper

import com.service.wtm.storage.entity.PlayerEntity
import com.service.wtm.core.domain.PlayerModel

fun PlayerEntity.toModel(): PlayerModel =
    PlayerModel(
        name = name,
        uuid = uuid.toString()
    )