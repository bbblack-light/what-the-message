package com.service.wtm.core.domain

import com.service.wtm.storage.entity.PlayerEntity

data class GameSessionModel (
    val owner: PlayerEntity
)