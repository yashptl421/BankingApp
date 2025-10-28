package com.yash.banking.customer_webservices.exceptions;


import com.yash.banking.customer_webservices.utils.ErrorCodes;

public class RecordNotFound extends BaseException {

    public RecordNotFound() {
        super("Account not found on the server", ErrorCodes.NOT_FOUND);
    }

    public RecordNotFound(String message) {
        super(message, ErrorCodes.NOT_FOUND);
    }
}