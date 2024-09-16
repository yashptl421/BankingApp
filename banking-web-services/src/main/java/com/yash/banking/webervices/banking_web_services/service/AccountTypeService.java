package com.yash.banking.webervices.banking_web_services.service;

import com.yash.banking.webervices.banking_web_services.dto.AccountTypes;
import com.yash.banking.webervices.banking_web_services.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountTypeService {

    @Autowired
    AccountTypeRepository accountTypeRepository;
    public AccountTypes getAccountType(int id){
        return accountTypeRepository.findById(id).get();
    }
    public List<AccountTypes> getAllAccountTypes(){
        return accountTypeRepository.findAll();
    }

    @Transactional
    public void addAccountTypes(AccountTypes accountTypes){
                accountTypeRepository.save(accountTypes);
    }
}
