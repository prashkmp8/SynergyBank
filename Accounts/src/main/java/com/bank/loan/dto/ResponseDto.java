package com.bank.loan.dto;

import lombok.*;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {

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

    private String message;
    private HttpStatus statusCode;
}
