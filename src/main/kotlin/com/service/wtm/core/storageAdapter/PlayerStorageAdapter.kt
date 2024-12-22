package com.service.wtm.core.storageAdapter

import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import java.util.UUID

interface PlayerStorageAdapter {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel
    fun getPlayer(uuid: UUID): PlayerModel
}