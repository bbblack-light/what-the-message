package com.service.wtm.service

import com.service.wtm.common.AbstractIntegrationTest
import org.junit.jupiter.api.Test

class PlayerServiceTest : AbstractIntegrationTest() {
    @Test
    fun `Should save tariff as expected`() {
        playerService.createPlayer("testPlayer")
    }

}