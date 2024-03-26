package com.service.wtm.storage.jpa

import com.service.wtm.storage.entity.PlayerEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<PlayerEntity, UUID>