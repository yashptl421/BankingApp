package com.yash.banking.customer_webservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${user.role}")
    private String userRole;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/config")
    public String getConfig() {
        return String.format("Role: %s, Message: %s", userRole, welcomeMessage);
    }
}
