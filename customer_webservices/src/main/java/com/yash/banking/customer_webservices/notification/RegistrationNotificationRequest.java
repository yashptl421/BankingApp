package com.yash.banking.customer_webservices.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class RegistrationNotificationRequest {
    String customerFirstname;
    String customerLastname;
    String customerEmail;
    Long customerId;
    Long aadharNumber;

}
