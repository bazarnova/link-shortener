package com.linkshortener.model;

import java.time.LocalDateTime;
import java.time.Period;

public class Url {

    private Long id;

    private String longUrl;
    private String shortUrl;
    private LocalDateTime createdDate;
    private LocalDateTime toDeleteDate;
    private LocalDateTime updatedDate;

    private Long userId;

    public Url() {
    }

    public Url(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Url(Long id, String longUrl, String shortUrl, LocalDateTime createdDate, LocalDateTime toDeleteDate, LocalDateTime updatedDate, Long userId) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.createdDate = createdDate;
        this.toDeleteDate = toDeleteDate;
        this.updatedDate = updatedDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
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

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getToDeleteDate() {
        return toDeleteDate;
    }

    public void setToDeleteDate(LocalDateTime toDeleteDate) {
        this.toDeleteDate = toDeleteDate;
    }
}
