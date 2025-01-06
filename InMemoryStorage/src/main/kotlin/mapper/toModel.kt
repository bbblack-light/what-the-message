package storage.inmemory.mapper

import core.domain.model.ModelGameType
import core.domain.model.session.SessionModel
import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.SmsCardType
import core.domain.model.player.PlayerModel
import storage.inmemory.entity.EntityGameType
import storage.inmemory.entity.PlayerEntity
import storage.inmemory.entity.SessionEntity
import storage.inmemory.entity.game.whatTheMessage.EntitySmsCardType
import storage.inmemory.entity.game.whatTheMessage.SmsCardEntity

internal fun PlayerEntity.toModel(): PlayerModel =
    PlayerModel(
        name = name,
        id = uuid.toString()
    )

internal fun SessionEntity.toModel(): SessionModel =
    SessionModel(
        ownerId = ownerId.toString(),
        id = uuid.toString(),
        game = sessionGame.toModel(),
        playersId = playersId.map { it.toString() }
    )

internal fun SmsCardEntity.toModel(): SmsCard =
    SmsCard(
        uuid = uuid.toString(),
        type = type.toModel(),
        text = text
    )

internal fun EntitySmsCardType.toModel(): SmsCardType =
    SmsCardType.valueOf(this.name)

internal fun EntityGameType.toModel(): ModelGameType =
    ModelGameType.valueOf(this.name)