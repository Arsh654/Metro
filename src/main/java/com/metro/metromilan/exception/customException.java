package com.metro.metromilan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class customException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(userNotFoundException.class)
    public final ResponseEntity<errorSchema> handleUserNotFoundExceptions(Exception ex, WebRequest request){
        errorSchema err = new errorSchema(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
