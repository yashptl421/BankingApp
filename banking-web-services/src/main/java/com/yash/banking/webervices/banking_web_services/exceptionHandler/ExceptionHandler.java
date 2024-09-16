package com.yash.banking.webervices.banking_web_services.exceptionHandler;

import com.yash.banking.webervices.banking_web_services.exceptions.AccountTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;


public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAccountTypeException(AccountTypeNotFoundException e){
    return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(),e.getMessage(), "Account Type does not exist"), HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInputValidation(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(),e.getFieldError().toString(), "Account Type does not exist"), HttpStatus.BAD_REQUEST);
    }
}
