package com.yash.banking.webervices.banking_web_services.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private final String errorCode;
    private final String errorMessage;

    public BaseException(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
