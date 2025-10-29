package com.yash.banking.customer_webservices.exceptions;

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
