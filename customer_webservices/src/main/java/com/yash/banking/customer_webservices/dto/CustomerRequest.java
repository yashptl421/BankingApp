package com.yash.banking.customer_webservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CustomerRequest {

    @JsonIgnore
    private Long customerId;
    @NotBlank(message = "Customer FirstName cannot be blank")
    @NotNull(message = "Customer firstname is required")
    private String firstName;
    @NotBlank(message = "Customer lirstName cannot be blank")
    @NotNull(message = "Customer lastName is required")
    private String lastName;
    private String address;
    private Integer pinCode;
    private LocalDate dob;
    @JsonIgnore
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