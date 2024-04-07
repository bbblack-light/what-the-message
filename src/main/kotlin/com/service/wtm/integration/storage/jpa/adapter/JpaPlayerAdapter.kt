package com.service.wtm.integration.storage.jpa.adapter

import com.service.wtm.core.adapter.PlayerAdapter
import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import com.service.wtm.integration.storage.jpa.PlayerRepository
import com.service.wtm.integration.storage.toModel
import com.service.wtm.integration.storage.toPlayerEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class JpaPlayerAdapter(
    private val playerRepository: PlayerRepository
) : PlayerAdapter {
    override fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel {
        return playerRepository.save(createPlayerModel.toPlayerEntity()).toModel()
    }

    override fun getPlayer(uuid: UUID): PlayerModel {
        val entity = playerRepository.findById(uuid)

        if(entity.isEmpty) throw IllegalArgumentException("Player not found")

        return entity.get().toModel()
    }
}