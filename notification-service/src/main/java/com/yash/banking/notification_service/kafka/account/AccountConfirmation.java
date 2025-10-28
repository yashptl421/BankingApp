package com.yash.banking.notification_service.kafka.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AccountConfirmation {
    String customerFirstname;
    String customerLastname;
    String customerEmail;
    String accountType;
    BigInteger accountNumber;
}
