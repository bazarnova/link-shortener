package com.linkshortener.service;

import com.linkshortener.model.Link;

public interface LinkGetService {

    Link getLinkByShortUrl(String shortUrl);
}
