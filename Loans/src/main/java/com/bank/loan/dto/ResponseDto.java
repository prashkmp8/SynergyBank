package com.bank.loan.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto {
    private String message;
    private HttpStatus statusCode;

    public ResponseDto(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseDto() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
