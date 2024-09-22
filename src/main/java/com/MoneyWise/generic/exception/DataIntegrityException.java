package com.MoneyWise.generic.exception;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityException(String message) {
        super(message);
    }
}

