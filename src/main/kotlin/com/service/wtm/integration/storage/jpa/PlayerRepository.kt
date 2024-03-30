package com.service.wtm.integration.storage.jpa

import com.service.wtm.integration.storage.entity.PlayerEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<PlayerEntity, UUID>