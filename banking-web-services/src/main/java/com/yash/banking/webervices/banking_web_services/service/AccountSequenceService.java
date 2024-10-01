package com.yash.banking.webervices.banking_web_services.service;

import com.yash.banking.webervices.banking_web_services.model.Sequence;
import com.yash.banking.webervices.banking_web_services.repository.AccountSequenceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountSequenceService {
    private final AccountSequenceRepository accountSequenceRepository;
    public Sequence generateAccountNumber() {

        log.info("creating a account number");
        return accountSequenceRepository.findById(1L)
                .map(sequence -> {
                    sequence.setAccountNumber(sequence.getAccountNumber().add(BigInteger.valueOf(1)));
                    return accountSequenceRepository.save(sequence);
                }).orElseGet(() -> accountSequenceRepository.save(Sequence.builder().accountNumber(BigInteger.valueOf(1)).build()));
    }
}
