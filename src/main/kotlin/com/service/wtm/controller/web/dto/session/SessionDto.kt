package com.service.wtm.controller.web.dto.session

import com.service.wtm.controller.web.dto.player.PlayerDto

data class SessionDto (
    val uuid: String,
    val owner: PlayerDto
)