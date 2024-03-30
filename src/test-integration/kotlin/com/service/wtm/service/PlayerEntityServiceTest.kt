package com.service.wtm.service

import com.service.wtm.common.AbstractIntegrationTest
import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.core.service.IPlayerService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.assertj.core.api.Assertions.assertThat

class PlayerEntityServiceTest : AbstractIntegrationTest() {

    @Autowired
    lateinit var sut: IPlayerService

    @Test
    fun `Save player`() {
        val name = "testPlayer"
        val sutInput = CreatePlayerModel(name)

        val saved = sut.createPlayer(sutInput)

        assertThat(saved).isNotNull
        assertThat(saved.name).isEqualTo(name)
        assertThat(saved.uuid).isNotBlank()
    }
}