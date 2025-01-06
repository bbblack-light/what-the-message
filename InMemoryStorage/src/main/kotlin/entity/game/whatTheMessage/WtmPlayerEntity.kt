package storage.inmemory.entity.game.whatTheMessage

import storage.inmemory.entity.ISessionPlayerEntity
import java.util.UUID

internal data class WtmPlayerEntity(
    override val playerId: UUID,
) : ISessionPlayerEntity