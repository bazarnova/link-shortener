package com.linkshortener.service.impl;

import com.linkshortener.dao.LinkDao;
import com.linkshortener.service.LinkDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkDeleteServiceImpl implements LinkDeleteService{

    @Autowired
    private LinkDao linkDao;

    @Override
    public void deleteByUrl(String shortUrl) {
        linkDao.deleteLinkByShortUrl(shortUrl);
    }
}
