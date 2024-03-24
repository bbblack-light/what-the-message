package com.service.wtm.db.entity

import java.util.UUID

data class GameSession (
    var id: UUID?,
    val owner: Player,
//    val incomingMessages: List<MessageCard>,
//    val outgoingMessages: List<MessageCard>,
    val players: List<SessionPlayer>,
//    val round: Round? = null
)
