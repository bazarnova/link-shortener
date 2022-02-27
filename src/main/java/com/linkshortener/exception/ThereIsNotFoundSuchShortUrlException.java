package com.linkshortener.exception;

public class ThereIsNotFoundSuchShortUrlException extends RuntimeException {
    public ThereIsNotFoundSuchShortUrlException(String message) {
        super(message);
    }
}
