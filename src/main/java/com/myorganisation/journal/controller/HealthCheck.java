package com.myorganisation.journal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    String health = "Server is Active!!";

    @GetMapping("/health-check")
    public String healthCheck() {
        return health;
    }
}
