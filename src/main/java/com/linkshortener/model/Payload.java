package com.linkshortener.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Payload {

    private String url;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expDate;

    private String name;
    private String signature;
    private String password;

    public Payload() {
    }

    public Payload(String url, LocalDateTime expDate, String name, String signature, String password) {
        this.url = url;
        this.expDate = expDate;
        this.name = name;
        this.signature = signature;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDateTime expDate) {
        this.expDate = expDate;
    }
}
