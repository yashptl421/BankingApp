package com.yash.banking.customer_webservices.controller;

import com.yash.banking.customer_webservices.dto.CustomerRequest;
import com.yash.banking.customer_webservices.dto.CustomerResponse;
import com.yash.banking.customer_webservices.dto.Response;
import com.yash.banking.customer_webservices.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/allCustomers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping("/register")
    public ResponseEntity<Response> saveCustomer(@RequestBody CustomerRequest request) {
        log.info("creating customer with: {}", request.toString());
        return ResponseEntity.ok(customerService.saveCustomer(request));
    }

    @GetMapping
    public ResponseEntity<CustomerResponse> readByCustomerId(@RequestParam Long customerId){
        log.info("read customer with: {}", customerId);
        return ResponseEntity.ok(customerService.readByCustomerId(customerId));
    }
}