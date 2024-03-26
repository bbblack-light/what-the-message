package com.service.wtm.service

import com.service.wtm.common.AbstractIntegrationTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.assertj.core.api.Assertions.assertThat

class PlayerServiceTest : AbstractIntegrationTest() {

    @Autowired
    lateinit var sut: IPlayerService

    @Test
    fun `Save player`() {
        val testPlayerName = "testPlayer"

        val saved = sut.createPlayer(testPlayerName)

        assertThat(saved).isNotNull
        assertThat(saved.name).isEqualTo(testPlayerName)
    }

}