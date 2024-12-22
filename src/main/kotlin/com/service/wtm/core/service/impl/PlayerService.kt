package com.service.wtm.core.service.impl

import com.service.wtm.core.storageAdapter.PlayerStorageAdapter
import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import com.service.wtm.core.service.IPlayerService
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerStorageAdapter: PlayerStorageAdapter
) : IPlayerService {
    override fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel {
        return playerStorageAdapter.createPlayer(createPlayerModel)
    }
}