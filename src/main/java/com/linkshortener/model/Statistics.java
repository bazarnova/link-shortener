package com.linkshortener.model;

import java.time.LocalDateTime;

public class Statistics {

    private Long id;
    private String shortUrl;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime followingDate;

    public Statistics() {
    }

    public Statistics(Long id, String shortUrl, LocalDateTime followingDate) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.followingDate = followingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getFollowingDate() {
        return followingDate;
    }

    public void setFollowingDate(LocalDateTime followingDate) {
        this.followingDate = followingDate;
    }
}
