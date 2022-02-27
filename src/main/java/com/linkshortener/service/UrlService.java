package com.linkshortener.service;

import com.linkshortener.model.Url;

public interface UrlService {

    Url createUrl(Url url);

    Url getUrlByShortLink(String shortLink);
}
