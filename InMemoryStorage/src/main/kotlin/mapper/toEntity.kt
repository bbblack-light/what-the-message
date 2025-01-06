package storage.inmemory.mapper

import core.domain.model.ModelGameType
import core.domain.storageAdapter.models.AdapterCreateSessionModel
import core.domain.model.game.whatTheMessage.SmsCardType
import core.domain.model.player.CreatePlayerRequestModel
import core.domain.model.player.PlayerModel
import storage.inmemory.entity.EntityGameType
import storage.inmemory.entity.ISessionPlayerEntity
import storage.inmemory.entity.PlayerEntity
import storage.inmemory.entity.SessionEntity
import storage.inmemory.entity.game.whatTheMessage.EntitySmsCardType
import storage.inmemory.entity.game.whatTheMessage.WtmPlayerEntity
import java.util.UUID

internal fun CreatePlayerRequestModel.toPlayerEntity(): PlayerEntity =
    PlayerEntity(
        uuid = UUID.randomUUID(),
        name = name
    )

internal fun AdapterCreateSessionModel.toSessionEntity(): SessionEntity {
    val owner = UUID.fromString(ownerId)
    val gameType = gameType.toEntity()
    return SessionEntity(
        uuid = UUID.randomUUID(),
        ownerId = owner,
        playersId = mutableListOf(owner),
        sessionGame = gameType,
    )
}

internal fun ModelGameType.toEntity(): EntityGameType =
    EntityGameType.valueOf(this.name)

internal fun PlayerModel.toPlayerEntity(): PlayerEntity =
    PlayerEntity(
        uuid = UUID.fromString(id),
        name = name
    )

internal fun SmsCardType.toEntity(): EntitySmsCardType =
    EntitySmsCardType.valueOf(this.name)