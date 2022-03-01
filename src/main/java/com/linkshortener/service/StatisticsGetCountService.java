package com.linkshortener.service;

import com.linkshortener.model.Payload;

import java.util.List;
import java.util.Map;

public interface StatisticsGetCountService {
    List<Map<String, Integer>> getCountStatistics(Payload payload);
}
