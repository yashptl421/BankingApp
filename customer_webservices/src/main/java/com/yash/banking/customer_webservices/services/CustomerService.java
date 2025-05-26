package com.yash.banking.customer_webservices.services;

import com.yash.banking.customer_webservices.dto.CustomerRequest;
import com.yash.banking.customer_webservices.dto.CustomerResponse;
import com.yash.banking.customer_webservices.dto.Response;
import com.yash.banking.customer_webservices.exceptions.CustomerNotFound;
import com.yash.banking.customer_webservices.model.Customers;
import com.yash.banking.customer_webservices.notification.NotificationProducer;
import com.yash.banking.customer_webservices.notification.RegistrationNotificationRequest;
import com.yash.banking.customer_webservices.repository.CustomerRepository;
import com.yash.banking.customer_webservices.utils.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ModelMapper mapper = new ModelMapper();
    private final NotificationProducer notificationProducer;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomer() {
        List<Customers> customersList = customerRepository.findAll();
        return customersList
                .stream()
                .map(c -> mapper.map(c, CustomerResponse.class))
                .toList();
    }

    public Response saveCustomer(CustomerRequest request) {
      Customers customer =  customerRepository.save(mapper.map(request, Customers.class));
        RegistrationNotificationRequest notificationRequest =new RegistrationNotificationRequest(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailId(),
                customer.getCustomerId(),
                customer.getAadharNumber()
        );
        notificationProducer.sendNotification(notificationRequest);
        return Response.builder()
                .responseMessage("Customer registered successfully")
                .responseCode(ResponseCode.RESPONSE_CODE_SUCCESS).build();

    }

    @Cacheable(value = "customerResponse", key = "#customerId")
    public CustomerResponse readByCustomerId(Long customerId) {
        return mapper.map(customerRepository.findById(customerId), CustomerResponse.class);
    }

    @CachePut(value = "customerResponse", key = "#request.customerId")
    public CustomerResponse updateCustomer(CustomerRequest request) {
        Customers customers = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new CustomerNotFound("Customer not exist"));
        customers.setAddress(request.getAddress());
        customers.setDob(request.getDob());
        customers.setContactNo(request.getContactNo());
        customers.setMartialStatus(request.getMartialStatus());
        customers.setPinCode(request.getPinCode());
        customers.setOccupation(request.getOccupation());
        return mapper.map(customerRepository.save(customers), CustomerResponse.class);
    }

    @CacheEvict(value = "customerResponse", key = "#request.customerId")
    public void deleteCustomer(CustomerRequest request) {
        customerRepository.deleteById(request.getCustomerId());
    }
}
