package com.springbootsauna.springbootsaunarestapi.exception;

public class HandleExceptionNotFound extends RuntimeException{

    public HandleExceptionNotFound(String message) {
        super(message);
    }

    public HandleExceptionNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
