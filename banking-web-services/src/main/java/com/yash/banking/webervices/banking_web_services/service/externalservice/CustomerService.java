package com.yash.banking.webervices.banking_web_services.service.externalservice;

import com.yash.banking.webervices.banking_web_services.dto.CustomerRequest;
import com.yash.banking.webervices.banking_web_services.dto.Response;
import com.yash.banking.webervices.banking_web_services.dto.external.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="customer-webservices")
public interface CustomerService {
    @PostMapping("/api/customer/register")
     ResponseEntity<Response> saveCustomer(@RequestBody CustomerRequest request);
    @GetMapping("/api/customer/allCustomers")
    ResponseEntity<List<CustomerResponse>> getAllCustomer();
    @GetMapping("/api/customer")
    ResponseEntity<CustomerResponse> readByCustomerId(@RequestParam Long customerId);
}
