package com.linkshortener.service;

import com.linkshortener.model.Link;
import com.linkshortener.model.Statistics;

public interface StatisticsCreateService {

    Statistics createStatistics (Link linkId);
}
