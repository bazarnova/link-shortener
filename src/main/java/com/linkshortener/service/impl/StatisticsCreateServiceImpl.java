package com.linkshortener.service.impl;

import com.linkshortener.dao.StatisticsDao;
import com.linkshortener.model.Link;
import com.linkshortener.model.Statistics;
import com.linkshortener.service.StatisticsCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatisticsCreateServiceImpl implements StatisticsCreateService {

    @Autowired
    StatisticsDao statisticsDao;

    @Override
    public Statistics createStatistics(Link linkId) {

        Statistics statistics = new Statistics();
        statistics.setFollowingDate(LocalDateTime.now());
        statistics.setShortUrl(linkId.getShortUrl());
        statisticsDao.saveStatistics(statistics);
        return statistics;
    }
}
