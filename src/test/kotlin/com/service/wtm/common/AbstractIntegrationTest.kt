package com.service.wtm.common

import com.service.wtm.config.PostgresContainer
import com.service.wtm.config.TestConfiguration
import com.service.wtm.service.IPlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@ActiveProfiles("test")
@SpringBootTest(
    classes = [TestConfiguration::class]
)
@ContextConfiguration(initializers = [PostgresContainer::class])
abstract class AbstractIntegrationTest {

}