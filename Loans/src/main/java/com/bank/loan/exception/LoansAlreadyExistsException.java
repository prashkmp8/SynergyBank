package com.bank.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class LoansAlreadyExistsException extends RuntimeException {
    public LoansAlreadyExistsException(String message) {
        super(message);
    }
}
