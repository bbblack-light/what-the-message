package com.service.wtm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WhatTheMessageApplication

fun main(args: Array<String>) {
    runApplication<WhatTheMessageApplication>(*args)
}
