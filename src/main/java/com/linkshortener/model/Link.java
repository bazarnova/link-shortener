package com.linkshortener.model;

import java.time.LocalDateTime;

public class Link {

    private Long id;

    private String url;
    private String shortUrl;
    private LocalDateTime createdDate;
    private LocalDateTime expDate;
    private Long userId;

    public Link() {
    }

    public Link(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Link(Long id, String url, String shortUrl, LocalDateTime createdDate, LocalDateTime expDate, Long userId) {
        this.id = id;
        this.url = url;
        this.shortUrl = shortUrl;
        this.createdDate = createdDate;
        this.expDate = expDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDateTime expDate) {
        this.expDate = expDate;
    }
}
