package com.yash.banking.customer_webservices.controller;

import com.yash.banking.customer_webservices.dto.CustomerRequest;
import com.yash.banking.customer_webservices.dto.CustomerResponse;
import com.yash.banking.customer_webservices.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/allCustomers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
        return new ResponseEntity<List<CustomerResponse>>(customerService.getAllCustomer(), HttpStatus.OK);
    }
    @PostMapping("/saveCustomer")
    public void saveCustomer(@RequestBody CustomerRequest request){
        customerService.saveCustomer(request);
    }

}
