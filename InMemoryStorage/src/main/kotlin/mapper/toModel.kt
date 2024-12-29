package storage.inmemory.mapper

import com.service.wtm.core.domain.model.session.SessionModel
import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.SmsCardType
import core.domain.model.player.PlayerModel
import storage.inmemory.entity.PlayerEntity
import storage.inmemory.entity.SessionEntity
import storage.inmemory.entity.game.whatTheMessage.EntitySmsCardType
import storage.inmemory.entity.game.whatTheMessage.SmsCardEntity

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

internal fun SmsCardEntity.toModel(): SmsCard =
    SmsCard(
        uuid = uuid.toString(),
        type = type.toModel(),
        text = text
    )

internal fun EntitySmsCardType.toModel(): SmsCardType =
    SmsCardType.valueOf(this.name)