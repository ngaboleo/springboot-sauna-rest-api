package com.springbootsauna.springbootsaunarestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppointmentExceptionHandler {

    @ExceptionHandler(value = {HandleExceptionNotFound.class})
    public ResponseEntity<Object>  handleRoleNotAppropriateException(HandleExceptionNotFound handleExceptionNotFound){
        HandlerException handlerException = new HandlerException(handleExceptionNotFound.getMessage(),
                handleExceptionNotFound.getCause(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(handlerException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
