package com.yash.banking.webervices.banking_web_services.exceptions;

public class AccountTypeNotFoundException extends RuntimeException{
    public AccountTypeNotFoundException(String message) {
        super(message);
    }
}
