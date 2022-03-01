package com.linkshortener.exception;

public class ThereIsNoSuchUserSignatureException extends RuntimeException{
    public ThereIsNoSuchUserSignatureException(String message) {
        super(message);
    }
}
