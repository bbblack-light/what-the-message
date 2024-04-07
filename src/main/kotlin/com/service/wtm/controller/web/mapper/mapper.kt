package com.service.wtm.controller.web.mapper

import com.service.wtm.controller.web.dto.player.CreatePlayerDto
import com.service.wtm.controller.web.dto.player.PlayerDto
import com.service.wtm.controller.web.dto.session.CreateSessionDto
import com.service.wtm.controller.web.dto.session.SessionDto
import com.service.wtm.core.domain.player.CreatePlayerModel
import com.service.wtm.core.domain.player.PlayerModel
import com.service.wtm.core.domain.session.CreateSessionModel
import com.service.wtm.core.domain.session.SessionModel

fun CreatePlayerDto.toModel(): CreatePlayerModel =
    CreatePlayerModel(name)

fun PlayerModel.toDto(): PlayerDto =
    PlayerDto(uuid, name)

fun SessionModel.toDto(): SessionDto =
    SessionDto(
        uuid = uuid,
        owner = owner.toDto()
    )

fun CreateSessionDto.toModel(): CreateSessionModel =
    CreateSessionModel(
        ownerUuid = ownerUuid
    )