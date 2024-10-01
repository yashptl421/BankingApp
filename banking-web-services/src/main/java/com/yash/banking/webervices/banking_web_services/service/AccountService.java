package com.yash.banking.webervices.banking_web_services.service;

import com.yash.banking.webervices.banking_web_services.dto.AccountRequest;
import com.yash.banking.webervices.banking_web_services.dto.AccountResponse;
import com.yash.banking.webervices.banking_web_services.dto.AccountTypes;
import com.yash.banking.webervices.banking_web_services.dto.external.CustomerResponse;
import com.yash.banking.webervices.banking_web_services.exceptions.RecordNotFound;
import com.yash.banking.webervices.banking_web_services.model.Account;
import com.yash.banking.webervices.banking_web_services.repository.AccountRepository;
import com.yash.banking.webervices.banking_web_services.repository.AccountTypeRepository;
import com.yash.banking.webervices.banking_web_services.service.externalservice.CustomerService;
import com.yash.banking.webervices.banking_web_services.utils.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountTypeRepository accountTypeRepository;
    private final ObjectMapper mapper;
    private final AccountSequenceService accountSequenceService;

    public BigInteger createAccount(AccountRequest request) {
        CustomerResponse customerResponse = customerService.readByCustomerId(request.getCustomerId()).getBody();
        if (Objects.isNull(customerResponse)) {
            throw new RecordNotFound("Customer dose not exists");
        }
        Optional<AccountTypes> accountTypes = accountTypeRepository.findById(request.getAccTypeid());
        if (accountTypes.isEmpty())
            throw new RecordNotFound("Invalid Account Type");
        Optional<Account> acc = accountRepository.findAccountByCustomerIdAndAccTypeid(request.getCustomerId(), request.getAccTypeid());
        if(acc.isPresent())
            throw new RecordNotFound("Account is already exist");
        Account account = mapper.map(request, Account.class);
        account.setAccountNumber(accountSequenceService.generateAccountNumber().getAccountNumber());
        return accountRepository.save(account).getAccountNumber();
    }

    public List<AccountResponse> allAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(acc -> mapper.map(acc, AccountResponse.class)).toList();
    }

    public AccountResponse getByAccountNumber(BigInteger accountNumber) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        return account.map(value -> mapper.map(value, AccountResponse.class)).orElse(null);
    }

    public String getBalance(BigInteger accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(account -> account.getAvailableBalance().toString())
                .orElseThrow(RecordNotFound::new);
    }

}