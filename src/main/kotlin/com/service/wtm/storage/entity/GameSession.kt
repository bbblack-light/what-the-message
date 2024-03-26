package com.service.wtm.storage.entity

import java.util.UUID

data class GameSession (
    var id: UUID?,
    val owner: PlayerEntity,
//    val incomingMessages: List<MessageCard>,
//    val outgoingMessages: List<MessageCard>,
    val players: List<SessionPlayer>,
//    val round: Round? = null
)
