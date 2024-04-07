package com.service.wtm.core.adapter

import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import java.util.UUID

interface PlayerAdapter {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel
    fun getPlayer(uuid: UUID): PlayerModel
}