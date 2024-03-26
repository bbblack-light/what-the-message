package com.service.wtm.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.UUID
import org.hibernate.annotations.GenericGenerator

@Entity(name="player")
data class PlayerEntity (
    @Id
    @Column(nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val uuid: UUID? = null,
    @Column(nullable = false, name = "name")
    val name: String = "",
)
