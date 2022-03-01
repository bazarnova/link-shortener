package com.linkshortener.exception;

public class ThereIsNoSuchUserException extends RuntimeException{
    public ThereIsNoSuchUserException(String message) {
        super(message);
    }
}
