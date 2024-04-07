package com.service.wtm.controller.web

import com.service.wtm.controller.web.dto.session.CreateSessionDto
import com.service.wtm.controller.web.dto.session.SessionDto
import com.service.wtm.controller.web.mapper.toDto
import com.service.wtm.controller.web.mapper.toModel
import com.service.wtm.core.domain.session.SessionModel
import com.service.wtm.core.service.ISessionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/session")
class SessionController(
    private val sessionService: ISessionService
) {
    @PostMapping("/create")
    fun createSession(@RequestBody createSessionDto: CreateSessionDto): SessionDto {
        return sessionService.createSession(createSessionDto.toModel()).toDto()
    }
}