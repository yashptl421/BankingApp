package com.yash.banking.webervices.banking_web_services.exceptions;

import com.yash.banking.webervices.banking_web_services.utils.ErrorCodes;

public class RecordNotFound extends BaseException {

    public RecordNotFound() {
        super("Account not found on the server", ErrorCodes.NOT_FOUND);
    }

    public RecordNotFound(String message) {
        super(message, ErrorCodes.NOT_FOUND);
    }
}