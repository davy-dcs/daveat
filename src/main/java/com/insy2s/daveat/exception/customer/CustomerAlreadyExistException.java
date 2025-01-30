package com.insy2s.daveat.exception.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
