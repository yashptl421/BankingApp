package com.yash.banking.webervices.banking_web_services.conroller;

import com.yash.banking.webervices.banking_web_services.dto.AccountRequest;
import com.yash.banking.webervices.banking_web_services.dto.AccountResponse;
import com.yash.banking.webervices.banking_web_services.dto.external.CustomerResponse;
import com.yash.banking.webervices.banking_web_services.service.AccountService;
import com.yash.banking.webervices.banking_web_services.service.externalservice.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public BigInteger createAccount(@RequestBody AccountRequest request) {
        log.info("creating account with: {}", request.toString());
        return accountService.createAccount(request);
    }

    @GetMapping("/allAccounts")
    public ResponseEntity<List<AccountResponse>> allAccounts() {
        return ResponseEntity.ok(accountService.allAccounts());
    }

    @GetMapping
    public ResponseEntity<AccountResponse> getByAccountNumber(@RequestParam BigInteger accountNumber) {
        return ResponseEntity.ok(accountService.getByAccountNumber(accountNumber));
    }

    @GetMapping("/balance")
    public ResponseEntity<String> accountBalance(@RequestParam BigInteger accountNumber) {
        return ResponseEntity.ok(accountService.getBalance(accountNumber));
    }
}
