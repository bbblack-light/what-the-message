package com.service.wtm.core.service

import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel

interface IPlayerService {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel
}