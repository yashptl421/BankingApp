package com.yash.banking.customer_webservices.repository;

import com.yash.banking.customer_webservices.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
