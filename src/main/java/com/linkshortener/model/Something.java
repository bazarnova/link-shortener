package com.linkshortener.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Something {

    private String longUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime toDeleteDate;

    private String identifier;
    private String signature;
    private String secretKey;

    public Something() {
    }

    public Something(String longUrl, LocalDateTime toDeleteDate, String identifier, String signature, String secretKey) {
        this.longUrl = longUrl;
        this.toDeleteDate = toDeleteDate;
        this.identifier = identifier;
        this.signature = signature;
        this.secretKey = secretKey;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDateTime getToDeleteDate() {
        return toDeleteDate;
    }

    public void setToDeleteDate(LocalDateTime toDeleteDate) {
        this.toDeleteDate = toDeleteDate;
    }
}
