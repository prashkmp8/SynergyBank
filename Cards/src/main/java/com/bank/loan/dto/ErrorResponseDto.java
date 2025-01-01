package com.bank.loan.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorResponseDto {
    private String message;
    private String errorCode;
    private LocalDate modifiedDate;
    private String path;

    public ErrorResponseDto(String message, String errorCode, LocalDate modifiedDate, String path) {
        this.message = message;
        this.errorCode = errorCode;
        this.modifiedDate = modifiedDate;
        this.path = path;
    }

    public ErrorResponseDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
