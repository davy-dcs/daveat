package com.insy2s.daveat.exception;

import com.insy2s.daveat.exception.customer.CustomerAlreadyExistException;
import com.insy2s.daveat.exception.customer.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CustomerAlreadyExistException.class)
    public void handleCustomerAlreadyExist(){}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public void handleCustomerNotFound(){}
}