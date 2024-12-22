package com.service.wtm.integration.storage.inmemory.entity;

import java.util.UUID

data class SessionEntity (
    val uuid: UUID,
    val player: PlayerEntity
)
