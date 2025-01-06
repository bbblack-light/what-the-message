package storage.inmemory.adapter

import core.domain.model.player.CreatePlayerRequestModel
import core.domain.model.player.PlayerModel
import core.domain.storageAdapter.PlayerStorageAdapter
import storage.inmemory.entity.PlayerEntity
import storage.inmemory.exceptions.NotFoundException
import storage.inmemory.mapper.toModel
import storage.inmemory.mapper.toPlayerEntity
import java.util.UUID

internal class InMemoryPlayerStorageAdapter() : PlayerStorageAdapter {
    private val players: MutableCollection<PlayerEntity> = mutableListOf()

    override fun createPlayer(request: CreatePlayerRequestModel): PlayerModel {
        val entity = request.toPlayerEntity()
        players.add(entity)
        return entity.toModel()
    }

    override fun getPlayer(id: String): PlayerModel {
        val uuid = UUID.fromString(id)
        return players.find { it.uuid == uuid }?.toModel() ?:
        throw NotFoundException("Player not found by uid $id")
    }

    override fun getPlayers(): List<PlayerModel> {
        return players.map { it.toModel() }
    }
}