package com.yash.banking.webervices.banking_web_services.repository;

import com.yash.banking.webervices.banking_web_services.dto.AccountTypes;
import com.yash.banking.webervices.banking_web_services.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(BigInteger accountNumber);
    Optional<Account> findAccountByCustomerIdAndAccTypeid(Long customerId, Long accTypeid);

}
