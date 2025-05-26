package com.yash.banking.notification_service.kafka.customer;

public record RegistrationConfirmation(
                String customerFirstname,
                String customerLastname,
                String customerEmail,
                Long customerId,
                Long aadharNumber
) {
        }