package com.linkshortener.dao;


import com.linkshortener.model.Link;

import java.time.LocalDateTime;

public interface LinkDao {

    int saveShortUrl(Link link, Long userId);

    Link findLinkByShortUrl(String shortUrl);

    int deleteLinkByShortUrl(String shortUrl);
}
