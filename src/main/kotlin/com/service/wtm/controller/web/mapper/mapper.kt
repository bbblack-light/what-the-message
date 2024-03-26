package com.service.wtm.controller.web.mapper

import com.service.wtm.controller.web.dto.CreatePlayerDto
import com.service.wtm.controller.web.dto.PlayerDto
import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.core.domain.PlayerModel

public fun CreatePlayerDto.toModel(): CreatePlayerModel =
    CreatePlayerModel(name)

public fun PlayerModel.toDto(): PlayerDto =
    PlayerDto(uuid.toString(), name)