package com.service.wtm.controller.web

import com.service.wtm.common.AbstractIntegrationTest
import com.service.wtm.controller.web.dto.player.CreatePlayerDto
import com.service.wtm.controller.web.dto.session.CreateSessionDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class SessionControllerTest : AbstractIntegrationTest() {
    @Autowired
    lateinit var sut: SessionController

    @Autowired
    lateinit var playerController: PlayerController

    @Test
    fun `Save session`() {
        val testPlayer = CreatePlayerDto("testPlayer")
        val savedTestPlayer = playerController.createPlayer(testPlayer)

        val testSessionInput = CreateSessionDto(savedTestPlayer.uuid)
        val testSession = sut.createSession(testSessionInput)

        assertThat(testSession.owner).isEqualTo(savedTestPlayer)
    }
}