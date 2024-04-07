package com.service.wtm.integration.storage

import com.service.wtm.core.domain.player.PlayerModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.integration.storage.entity.PlayerEntity
import com.service.wtm.integration.storage.entity.SessionEntity

fun PlayerEntity.toModel(): PlayerModel =
    PlayerModel(
        name = name,
        uuid = uuid.toString()
    )

fun SessionEntity.toModel(): SessionModel =
    SessionModel(
        owner = player.toModel(),
        uuid = uuid.toString()
    )