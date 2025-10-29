package com.yash.banking.webervices.banking_web_services.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "account_types")
public class AccountTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accTypeid;
    private String accountName;
    private double interestRate;
    private double amountLimit;
    private double depositLimit;

}
