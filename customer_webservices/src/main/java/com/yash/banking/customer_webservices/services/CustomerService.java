package com.yash.banking.customer_webservices.services;

import com.yash.banking.customer_webservices.dto.CustomerRequest;
import com.yash.banking.customer_webservices.dto.CustomerResponse;
import com.yash.banking.customer_webservices.model.Customers;
import com.yash.banking.customer_webservices.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomer() {
        List<Customers> customersList = customerRepository.findAll();
        return customersList
                .stream()
                .map(c -> mapper.map(c, CustomerResponse.class))
                .toList();
    }
    public void saveCustomer(CustomerRequest request){
        request.setAccOpeningDate(LocalDateTime.now());
        customerRepository.save(mapper.map(request, Customers.class));
    }
}
