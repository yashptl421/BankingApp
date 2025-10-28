package com.yash.banking.webervices.banking_web_services.notification;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@AllArgsConstructor
@Data
public class AccountCreatedRequest {
    String customerFirstname;
    String customerLastname;
    String customerEmail;
    String accountType;
    BigInteger accountNumber;
}
