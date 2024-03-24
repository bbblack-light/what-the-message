package com.service.wtm.service

import com.service.wtm.model.PlayerModel

interface IPlayerService {
    fun createPlayer(name: String): PlayerModel
}