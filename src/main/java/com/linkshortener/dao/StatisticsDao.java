package com.linkshortener.dao;

import com.linkshortener.model.Link;
import com.linkshortener.model.Statistics;

import java.util.List;
import java.util.Map;


public interface StatisticsDao {

    int saveStatistics(Statistics statistics);

    List<Statistics> findByLink(Link link);

    List<Map<String,Integer>> findByUserName(String name);
}
