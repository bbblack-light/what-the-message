package com.service.wtm.service

import com.service.wtm.common.AbstractTest
import com.service.wtm.core.domain.CreatePlayerModel
import com.service.wtm.core.service.IPlayerService
import com.service.wtm.core.service.impl.PlayerService
import com.service.wtm.integration.storage.entity.PlayerEntity
import com.service.wtm.integration.storage.jpa.PlayerRepository
import com.service.wtm.integration.storage.jpa.adapter.JpaPlayerAdapter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.UUID

@ExtendWith(MockitoExtension::class)
class PlayerServiceTest : AbstractTest() {

    lateinit var sut: IPlayerService

    @Mock
    lateinit var playerRepository: PlayerRepository

    @BeforeEach
    fun setUp() {
        val playerAdapter = JpaPlayerAdapter(playerRepository = playerRepository)
        sut = PlayerService(
            playerAdapter = playerAdapter
        )
    }

    @Test
    fun `Save player`() {
        val name = "testPlayer"
        val uuid = UUID.randomUUID()

        val sutInput = CreatePlayerModel(name)

        val createdPlayerEntity = PlayerEntity(
            uuid,
            name
        )

        `when`(playerRepository.save(any())).thenReturn(createdPlayerEntity)

        val saved = sut.createPlayer(sutInput)

        assertThat(saved).isNotNull
        assertThat(saved.name).isEqualTo(name)
        assertThat(saved.uuid).isEqualTo(uuid)
    }
}