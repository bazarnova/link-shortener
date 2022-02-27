package com.linkshortener.dao;


import com.linkshortener.model.Url;

public interface UrlDao {

    int saveShortUrl(Url url);

    Url findUrlByShortLink(String shortLink);

    int deleteUrlByShortUrl(String shortLink);
}
