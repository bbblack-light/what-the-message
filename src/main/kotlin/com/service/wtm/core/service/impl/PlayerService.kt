package com.service.wtm.core.service.impl

import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.integration.storage.entity.PlayerEntity
import com.service.wtm.integration.storage.jpa.PlayerRepository
import com.service.wtm.core.domain.PlayerModel
import com.service.wtm.core.service.IPlayerService
import com.service.wtm.integration.storage.toModel
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) : IPlayerService {
    override fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel {
        val entity = PlayerEntity(name = createPlayerModel.name)
        return playerRepository.save(entity).toModel()
    }
}