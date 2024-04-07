package com.service.wtm.integration.storage.jpa

import com.service.wtm.integration.storage.entity.SessionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SessionRepository : JpaRepository<SessionEntity, UUID> {
}