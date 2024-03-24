package com.service.wtm.service.impl

import com.service.wtm.db.entity.Player
import com.service.wtm.db.repo.PlayerRepository
import com.service.wtm.mapper.toModel
import com.service.wtm.model.PlayerModel
import com.service.wtm.service.IPlayerService
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) : IPlayerService {
    override fun createPlayer(name: String): PlayerModel {
        return playerRepository.save(Player(name = name)).toModel()
    }
}