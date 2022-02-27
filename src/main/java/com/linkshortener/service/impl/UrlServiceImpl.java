package com.linkshortener.service.impl;

import com.linkshortener.dao.UrlDao;
import com.linkshortener.exception.ThereIsNotFoundSuchShortUrlException;
import com.linkshortener.model.Url;
import com.linkshortener.service.UrlService;
import com.linkshortener.util.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private ShortUrlGenerator generator;

    @Autowired
    private UrlDao urlDao;

    @Override
    public Url createUrl(Url url) {
        if (url == null) {
            return null;
        }

        int shortUrlLength = 6;
        String generatedUrl = generator.generate(shortUrlLength);
        url.setShortUrl(generatedUrl);
        urlDao.saveShortUrl(url);
        return url;
    }

    @Override
    public Url getUrlByShortLink(String shortLink) {
        Url url = urlDao.findUrlByShortLink(shortLink);
        if(url == null) {
            throw new ThereIsNotFoundSuchShortUrlException("There is not such url.");
        }

        return url;
    }
}
