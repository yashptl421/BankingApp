package com.yash.banking.webervices.banking_web_services.conroller;

import com.yash.banking.webervices.banking_web_services.dto.AccountTypes;
import com.yash.banking.webervices.banking_web_services.exceptions.AccountTypeNotFoundException;
import com.yash.banking.webervices.banking_web_services.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping("/banking/accountTypes/{id}")
    public ResponseEntity<AccountTypes>  getAccountType(@PathVariable int id) {
        AccountTypes accountType = accountTypeService.getAccountType(id);
        if(accountType==null)
            throw new AccountTypeNotFoundException("ID" +id);

        return new ResponseEntity<>(accountType, HttpStatus.OK);
    }

    @GetMapping("/banking/accountTypes")
    public ResponseEntity<List<AccountTypes>> getAllAccountType() {
        List<AccountTypes> accountTypes = accountTypeService.getAllAccountTypes();
        return new ResponseEntity<>(accountTypes, HttpStatus.OK);
    }

    @PostMapping("/banking/addAccountType")
    public void addAccountType(@RequestBody AccountTypes accountType){
        accountTypeService.addAccountTypes(accountType);
    }
}
