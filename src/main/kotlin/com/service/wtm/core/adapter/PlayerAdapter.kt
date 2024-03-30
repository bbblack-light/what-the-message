package com.service.wtm.core.adapter

import com.service.wtm.core.domain.CreatePlayerModel

interface PlayerAdapter {
    fun createPlayer(createPlayerModel: CreatePlayerModel)
}