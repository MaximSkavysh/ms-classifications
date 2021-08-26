package com.lobster.core.exception;

public class AlreadyUsedException extends RuntimeException{
    public AlreadyUsedException(String message) {
        super(message);
    }
}
