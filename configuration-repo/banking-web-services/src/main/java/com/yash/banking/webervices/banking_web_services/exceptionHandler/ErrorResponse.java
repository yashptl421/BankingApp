package com.yash.banking.webervices.banking_web_services.exceptionHandler;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime dateTime;
    private String message;
    private String discription;

    public ErrorResponse(LocalDateTime dateTime, String message, String discription) {
        this.dateTime = dateTime;
        this.message = message;
        this.discription = discription;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
