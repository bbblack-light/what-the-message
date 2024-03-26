package com.service.wtm.controller.web

import com.service.wtm.common.AbstractIntegrationTest
import com.service.wtm.controller.web.dto.CreatePlayerDto
import com.service.wtm.controller.web.dto.PlayerDto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


class PlayerControllerTest : AbstractIntegrationTest() {
    @Autowired
    lateinit var sut: PlayerController

    @Test
    fun `Save player`() {
        val testPlayer = CreatePlayerDto("testPlayer")

        val saved = sut.createPlayer(testPlayer)

        Assertions.assertThat(saved).isNotNull
        Assertions.assertThat(saved.name).isEqualTo(testPlayer.name)
        Assertions.assertThat(saved.uuid).isNotBlank()
    }
}