package com.yash.banking.customer_webservices.controller;

import com.yash.banking.customer_webservices.response.ConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    ConfigResponse response;
    @GetMapping("/config")
    public String getConfig() {
        return String.format("Role: %s, Message: %s", response.getRole(), response.getMessage());
    }
}
