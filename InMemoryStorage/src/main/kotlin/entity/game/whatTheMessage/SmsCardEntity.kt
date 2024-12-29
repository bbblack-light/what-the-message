package storage.inmemory.entity.game.whatTheMessage

import java.util.*

internal data class SmsCardEntity (
    val uuid: UUID,
    val type: EntitySmsCardType,
    val text: String
)