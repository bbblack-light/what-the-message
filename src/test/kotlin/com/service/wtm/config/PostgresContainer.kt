package com.service.wtm.config

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName
import java.util.UUID

class PostgresContainer :
    PostgreSQLContainer<PostgresContainer>(
        DockerImageName.parse(IMAGE_NAME).asCompatibleSubstituteFor(SUBSTITUTED_NAME)
    ),
    ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(context: ConfigurableApplicationContext) {
        postgresContainer.start()
        TestPropertyValues.of(
            "spring.datasource.url=${postgresContainer.jdbcUrl}",
//            "spring.liquibase.url=${postgresContainer.jdbcUrl}"
        ).applyTo(context.environment)
    }

    companion object {
        private const val IMAGE_NAME = "postgres:14.3"
        private const val SUBSTITUTED_NAME = "postgres"
        private const val CONTAINER_USERNAME = "postgres"
        private const val CONTAINER_PASSWORD = "postgres"
        private const val CONTAINER_DB = "game"
        private const val CONTAINER_SCHEMA = "game"
        private const val CONTAINER_INIT_SCRIPT = "db/01-init.sql"
        val postgresContainer: PostgresContainer = PostgresContainer()
            .apply {
                withUsername(CONTAINER_USERNAME)
                withPassword(CONTAINER_PASSWORD)
                withDatabaseName(CONTAINER_DB)
                withUrlParam("currentSchema", CONTAINER_SCHEMA)
                withExposedPorts(5432)
                withInitScript(CONTAINER_INIT_SCRIPT)
                withCreateContainerCmdModifier { it.withName("test_containers_pg_container_${UUID.randomUUID()}") }
                waitingFor(Wait.forListeningPort())
            }
    }
}
