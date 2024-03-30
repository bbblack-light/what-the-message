package com.service.wtm.common

import com.service.wtm.config.PostgresContainer
import com.service.wtm.config.TestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@ActiveProfiles("test-integration")
@SpringBootTest(
    classes = [TestConfiguration::class]
)
@ContextConfiguration(initializers = [PostgresContainer::class])
abstract class AbstractIntegrationTest {

}