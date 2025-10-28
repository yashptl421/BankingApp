package com.yash.banking.notification_service.email;

import lombok.Getter;

public enum EmailTemplates {

    REGISTRATION_CONFIRMATION("Registration-Confirm.html", "Registration successfully completed"),
    ACCOUNT_CONFIRMATION("Account-Confirm.html","Account created successfully");

    @Getter
    private final String template;
    @Getter
    private final String subject;


    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
