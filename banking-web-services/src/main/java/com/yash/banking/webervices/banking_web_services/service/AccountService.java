package com.yash.banking.webervices.banking_web_services.service;

import com.yash.banking.webervices.banking_web_services.dto.AccountRequest;
import com.yash.banking.webervices.banking_web_services.dto.AccountResponse;
import com.yash.banking.webervices.banking_web_services.dto.AccountTypes;
import com.yash.banking.webervices.banking_web_services.dto.CustomerAccountResponse;
import com.yash.banking.webervices.banking_web_services.dto.external.CustomerResponse;
import com.yash.banking.webervices.banking_web_services.exceptions.RecordNotFound;
import com.yash.banking.webervices.banking_web_services.model.Account;
import com.yash.banking.webervices.banking_web_services.notification.AccountCreatedRequest;
import com.yash.banking.webervices.banking_web_services.notification.NotificationProducer;
import com.yash.banking.webervices.banking_web_services.repository.AccountRepository;
import com.yash.banking.webervices.banking_web_services.repository.AccountTypeRepository;
import com.yash.banking.webervices.banking_web_services.service.externalservice.CustomerService;
import com.yash.banking.webervices.banking_web_services.utils.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountTypeRepository accountTypeRepository;
    private final ObjectMapper mapper;
    private final AccountSequenceService accountSequenceService;
    private final NotificationProducer notificationProducer;
    public BigInteger createAccount(AccountRequest request) {
        CustomerResponse customerResponse = customerService.readByCustomerId(request.getCustomerId()).getBody();
        if (Objects.isNull(customerResponse)) {
            throw new RecordNotFound("Customer dose not exists");
        }
        Optional<AccountTypes> accountTypes = accountTypeRepository.findById(request.getAccTypeid());
        if (accountTypes.isEmpty())
            throw new RecordNotFound("Invalid Account Type");
        Optional<Account> acc = accountRepository.findAccountByCustomerIdAndAccTypeid(request.getCustomerId(), request.getAccTypeid());
        if (acc.isPresent())
            throw new RecordNotFound("Account is already exist");
        Account account = mapper.map(request, Account.class);
        account.setAccountNumber(accountSequenceService.generateAccountNumber().getAccountNumber());
        BigInteger accNumber = accountRepository.save(account).getAccountNumber();

        //Email notification needs to send for account created confirmation.
        AccountCreatedRequest accountCreatedRequest = new AccountCreatedRequest(
                customerResponse.getFirstName(),
                customerResponse.getLastName(),
                customerResponse.getEmailId(),
                accountTypes.get().getAccountName(),
                accNumber
                );
        notificationProducer.sendNotification(accountCreatedRequest);
        return accNumber;
    }

    public List<AccountResponse> allAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(acc -> mapper.map(acc, AccountResponse.class)).toList();
    }

    @CircuitBreaker(name = "customer", fallbackMethod = "getByAccountNumberFallback")
    public CustomerAccountResponse getByAccountNumber(BigInteger accountNumber) {

        CustomerAccountResponse response = new CustomerAccountResponse();
        ResponseEntity<CustomerResponse> customerResponse;
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        if (account.isPresent())
            customerResponse = customerService.readByCustomerId(account.get().getCustomerId());
        else
            throw new RecordNotFound("Account Not Found");
        if (Objects.isNull(customerResponse.getBody()))
            throw new RecordNotFound("Customer Not Found");
        response.setAccountResponse(account.map(value -> mapper.map(value, AccountResponse.class)).orElse(null));
        response.setCustomerResponse(customerResponse.getBody());
        return response;
    }

    public String getBalance(BigInteger accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(account -> account.getAvailableBalance().toString())
                .orElseThrow(RecordNotFound::new);
    }

    public CustomerAccountResponse getByAccountNumberFallback(Exception e) {
        return new CustomerAccountResponse();
    }
}