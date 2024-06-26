package com.service.wtm.controller.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheck {

    @GetMapping("/healthcheck")
    fun healthCheck(): Boolean {
        return true
    }
}