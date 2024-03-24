package com.service.wtm.db.repo

import com.service.wtm.db.entity.Player
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<Player, UUID>