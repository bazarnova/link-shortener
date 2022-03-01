package com.linkshortener.service.impl;

import com.linkshortener.dao.LinkDao;
import com.linkshortener.exception.ThereIsNotFoundSuchShortUrlException;
import com.linkshortener.model.Link;
import com.linkshortener.service.LinkGetService;
import com.linkshortener.service.StatisticsCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkGetServiceImpl implements LinkGetService {

    @Autowired
    private LinkDao linkDao;

    @Autowired
    StatisticsCreateService statisticsCreateService;

    @Override
    public Link getLinkByShortUrl(String shortUrl) {
        Link link = linkDao.findLinkByShortUrl(shortUrl);
        if (link == null) {
            throw new ThereIsNotFoundSuchShortUrlException("There is not such url.");
        }
        statisticsCreateService.createStatistics(link);
        return link;
    }
}
