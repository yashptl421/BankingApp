package com.yash.banking.customer_webservices.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigResponse {
    @Value("${user.role}")
    private String userRole;

    @Value("${welcome.message}")
    private String welcomeMessage;

    // Getter methods
    public String getUserRole() {
        return userRole;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }
}
