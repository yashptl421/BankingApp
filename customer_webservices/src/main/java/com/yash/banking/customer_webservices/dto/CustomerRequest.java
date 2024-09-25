package com.yash.banking.customer_webservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String address;
    private Integer pinCode;
    private LocalDate dob;
    @JsonIgnore
    private LocalDateTime accOpeningDate;
    private Long aadharNumber;
    private String panNumber;

}
