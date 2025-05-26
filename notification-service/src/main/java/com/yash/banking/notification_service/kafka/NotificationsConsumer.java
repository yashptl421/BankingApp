package com.yash.banking.notification_service.kafka;

import com.yash.banking.notification_service.email.EmailService;
import com.yash.banking.notification_service.kafka.customer.RegistrationConfirmation;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationsConsumer {
    private final EmailService emailService;
    @KafkaListener(topics = "registration-topic", groupId = "customerGroup")
    public void consumeRegistrationSuccessNotifications(RegistrationConfirmation registrationConfirmation) throws MessagingException {
        var customerName = registrationConfirmation.customerFirstname() + " " + registrationConfirmation.customerLastname();
        emailService.sendRegistrationSuccessEmail(
                registrationConfirmation.customerEmail(),
                customerName,
                registrationConfirmation.customerId(),
                registrationConfirmation.aadharNumber()
        );
    }
}
