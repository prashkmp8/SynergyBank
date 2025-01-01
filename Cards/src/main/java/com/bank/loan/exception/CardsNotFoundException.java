package com.bank.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardsNotFoundException extends RuntimeException{
    public CardsNotFoundException(String message) {
        super(message);
    }
}
