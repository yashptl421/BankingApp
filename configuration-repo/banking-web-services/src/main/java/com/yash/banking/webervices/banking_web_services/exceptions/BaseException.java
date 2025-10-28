package com.yash.banking.webervices.banking_web_services.exceptions;

public class BaseException extends RuntimeException{

    private final String errorCode;

    private final String errorMessage;

    public BaseException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
