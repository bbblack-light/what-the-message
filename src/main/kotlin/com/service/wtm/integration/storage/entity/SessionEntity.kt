package com.service.wtm.integration.storage.entity;

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity(name="session")
data class SessionEntity (
    @Id
    @Column(nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val uuid: UUID? = null,

    @ManyToOne
    @JoinColumn(name="player_id", nullable=false)
    val player: PlayerEntity = PlayerEntity()
)
