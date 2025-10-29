package com.yash.banking.webervices.banking_web_services.exceptionHandler;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private LocalDateTime dateTime;
    private String message;
    private String description;
    Map<String, String> errors;

    public ErrorResponse(LocalDateTime dateTime, String message, String description) {
        this.dateTime = dateTime;
        this.message = message;
        this.description = description;
    }

    public ErrorResponse(Map<String, String> errors) {
        this.errors = errors;
    }
    public ErrorResponse(LocalDateTime dateTime, String message, String description, Map<String, String> errors) {
        this.errors = errors;
    }
}
