package com.example.controller_advice_demo.exception;

import com.example.controller_advice_demo.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchError(StudentException e) {
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchError(Exception e) {
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }
}
