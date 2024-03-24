package com.service.wtm.controller

import com.service.wtm.model.PlayerModel
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/player")
class PlayerController {
    @GetMapping("/create")
    fun createPlayer(name:String): PlayerModel{
        return PlayerModel(UUID.randomUUID().toString(), name)
    }
}