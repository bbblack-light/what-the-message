package storage.inmemory.entity

import java.util.UUID

internal data class PlayerEntity (
    val uuid: UUID,
    val name: String,
)
