package com.yash.banking.webervices.banking_web_services.exceptionHandler;

import com.yash.banking.webervices.banking_web_services.exceptions.RecordNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/*@RestControllerAdvice is a specialized annotation in Spring Framework used for handling exceptions globally in REST APIs.
It combines the functionalities of @ControllerAdvice and @ResponseBody.*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<ErrorResponse> handelRecordNotFound(RecordNotFound exp){

        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorResponse(LocalDateTime.now(),exp.getErrorMessage(),"Please recheck and try again!!"));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }
}
