package com.service.wtm.integration.storage.inmemory.adapter

import com.service.wtm.core.storageAdapter.PlayerStorageAdapter
import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import com.service.wtm.integration.storage.inmemory.entity.PlayerEntity
import com.service.wtm.integration.storage.inmemory.exceptions.NotFoundException
import com.service.wtm.integration.storage.inmemory.mapper.toModel
import com.service.wtm.integration.storage.inmemory.mapper.toPlayerEntity
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class InMemoryPlayerStorageAdapter() : PlayerStorageAdapter {
    private val players: MutableCollection<PlayerEntity> = mutableListOf()

    override fun createPlayer(createPlayerModel: CreatePlayerModel): PlayerModel {
        val entity = createPlayerModel.toPlayerEntity()
        players.add(entity)
        return entity.toModel()
    }

    override fun getPlayer(uuid: UUID): PlayerModel {
        return players.find { it.uuid == uuid }?.toModel() ?:
        throw NotFoundException("Player not found by uid $uuid")
    }
}