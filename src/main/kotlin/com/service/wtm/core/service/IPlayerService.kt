package com.service.wtm.core.service

import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.core.domain.PlayerModel

interface IPlayerService {
    fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel
}