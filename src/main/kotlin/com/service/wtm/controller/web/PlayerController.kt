package com.service.wtm.controller.web

import com.service.wtm.controller.web.dto.player.CreatePlayerDto
import com.service.wtm.controller.web.dto.player.PlayerDto
import com.service.wtm.controller.web.mapper.toDto
import com.service.wtm.controller.web.mapper.toModel
import com.service.wtm.core.service.IPlayerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/player")
class PlayerController (
    private val playerService: IPlayerService
){
    @PostMapping("/create")
    fun createPlayer(@RequestBody createPlayer: CreatePlayerDto): PlayerDto {
        return playerService.createPlayer(createPlayer.toModel()).toDto()
    }
}
