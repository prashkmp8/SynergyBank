package com.bank.loan.handler;


import com.bank.loan.dto.ErrorResponseDto;
import com.bank.loan.exception.CardsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class CardsExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> cardNotFoundException(CardsNotFoundException ex){
        ErrorResponseDto dto =new ErrorResponseDto(ex.getMessage(),HttpStatus.NOT_FOUND.name(), LocalDate.now(),"");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> exception(Exception ex){
        ErrorResponseDto dto =new ErrorResponseDto(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.name(), LocalDate.now(),"");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }

}