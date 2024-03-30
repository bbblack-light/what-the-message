package com.service.wtm.integration.storage

import com.service.wtm.core.domain.PlayerModel
import com.service.wtm.integration.storage.entity.PlayerEntity

fun PlayerEntity.toModel(): PlayerModel =
    PlayerModel(
        name = name,
        uuid = uuid.toString()
    )