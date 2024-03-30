package com.service.wtm.core.adapter

import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.core.domain.PlayerModel

interface PlayerAdapter {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel
}