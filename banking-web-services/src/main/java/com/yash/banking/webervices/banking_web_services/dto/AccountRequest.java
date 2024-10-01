package com.yash.banking.webervices.banking_web_services.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
public class AccountRequest {
    @JsonIgnore
    private Long accountId;
    @JsonIgnore
    private BigInteger accountNumber;

    private Long accTypeid;

    private String accountStatus;

    private BigDecimal availableBalance;

    private Long customerId;

}
