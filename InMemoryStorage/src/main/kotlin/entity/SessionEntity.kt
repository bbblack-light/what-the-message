package storage.inmemory.entity;

import java.util.UUID

internal data class SessionEntity (
    val uuid: UUID,
    val player: PlayerEntity
)
