package com.yash.banking.webervices.banking_web_services.dto.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String address;
    private Integer pinCode;
    private LocalDate dob;
    private LocalDateTime accOpeningDate;
    private Long aadharNumber;
    private String emailId;
    private Long contactNo;
    private String panNumber;
    private String gender;
    private String occupation;
    private String martialStatus;
    private String nationality;

}
