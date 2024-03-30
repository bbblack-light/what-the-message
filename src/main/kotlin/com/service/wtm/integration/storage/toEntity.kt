package com.service.wtm.integration.storage

import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.integration.storage.entity.PlayerEntity

fun CreatePlayerModel.toPlayerEntity() =
    PlayerEntity(name = name)