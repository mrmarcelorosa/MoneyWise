package com.MoneyWise.generic.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}

