package com.service.wtm.integration.storage.inmemory.mapper

import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.integration.storage.inmemory.entity.PlayerEntity
import com.service.wtm.integration.storage.inmemory.entity.SessionEntity
import java.util.*

fun CreatePlayerModel.toPlayerEntity() =
    PlayerEntity(
        uuid = UUID.randomUUID(),
        name = name
    )

fun CreateSessionModel.toSessionEntity(playerEntity: PlayerEntity) =
    SessionEntity(
        uuid = UUID.randomUUID(),
        player = playerEntity
    )

fun PlayerModel.toPlayerEntity() =
    PlayerEntity(
        uuid = UUID.fromString(uuid),
        name = name
    )