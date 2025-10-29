package com.yash.banking.customer_webservices.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
