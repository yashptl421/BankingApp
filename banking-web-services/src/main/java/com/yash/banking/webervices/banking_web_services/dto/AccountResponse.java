package com.yash.banking.webervices.banking_web_services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountResponse {

    private Long accountId;

    private BigInteger accountNumber;

    private Long accTypeid;

    private String accountStatus;

    private BigDecimal availableBalance;

    private Long customerId;

}