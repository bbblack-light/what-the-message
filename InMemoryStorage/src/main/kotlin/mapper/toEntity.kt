package storage.inmemory.mapper

import com.service.wtm.core.domain.model.session.CreateSessionModel
import core.domain.model.player.CreatePlayerModel
import core.domain.model.player.PlayerModel
import storage.inmemory.entity.PlayerEntity
import storage.inmemory.entity.SessionEntity
import java.util.UUID

internal fun CreatePlayerModel.toPlayerEntity(): PlayerEntity =
    PlayerEntity(
        uuid = UUID.randomUUID(),
        name = name
    )

internal fun CreateSessionModel.toSessionEntity(playerEntity: PlayerEntity): SessionEntity =
    SessionEntity(
        uuid = UUID.randomUUID(),
        player = playerEntity
    )

internal fun PlayerModel.toPlayerEntity(): PlayerEntity =
    PlayerEntity(
        uuid = UUID.fromString(uuid),
        name = name
    )