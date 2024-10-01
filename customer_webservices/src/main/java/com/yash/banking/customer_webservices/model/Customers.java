package com.yash.banking.customer_webservices.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity(name = "customer_data")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String firstName;
    private String lastName;
    private String address;
    private Integer pinCode;
    private LocalDate dob;
    @CreationTimestamp
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
