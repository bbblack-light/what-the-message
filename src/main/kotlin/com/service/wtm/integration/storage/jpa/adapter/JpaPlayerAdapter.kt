package com.service.wtm.integration.storage.jpa.adapter

import com.service.wtm.core.adapter.PlayerAdapter
import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.core.domain.PlayerModel
import com.service.wtm.integration.storage.jpa.PlayerRepository
import com.service.wtm.integration.storage.toModel
import com.service.wtm.integration.storage.toPlayerEntity
import org.springframework.stereotype.Component

@Component
class JpaPlayerAdapter(
    private val playerRepository: PlayerRepository
) : PlayerAdapter {
    override fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel {
        return playerRepository.save(createPlayerModel.toPlayerEntity()).toModel()
    }
}