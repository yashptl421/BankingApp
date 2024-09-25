package com.yash.banking.customer_webservices.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String address;
    private Integer pinCode;
    private LocalDate dob;
    private LocalDateTime accOpeningDate;
    private Long aadharNumber;
    private String panNumber;

}
