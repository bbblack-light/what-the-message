package storage.inmemory.mapper

import com.service.wtm.core.domain.model.session.SessionModel
import core.domain.model.player.PlayerModel
import storage.inmemory.entity.PlayerEntity
import storage.inmemory.entity.SessionEntity

internal fun PlayerEntity.toModel(): PlayerModel =
    PlayerModel(
        name = name,
        uuid = uuid.toString()
    )

internal fun SessionEntity.toModel(): SessionModel =
    SessionModel(
        owner = player.toModel(),
        uuid = uuid.toString()
    )