package com.linkshortener.service.impl;

import com.linkshortener.dao.StatisticsDao;
import com.linkshortener.dao.UserDao;
import com.linkshortener.exception.ThereIsNoSuchUserException;
import com.linkshortener.exception.ThereIsNoSuchUserSignatureException;
import com.linkshortener.model.Payload;
import com.linkshortener.model.User;
import com.linkshortener.service.StatisticsGetCountService;
import com.linkshortener.util.CreateSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsGetCountServiceImpl implements StatisticsGetCountService {

    @Autowired
    StatisticsDao statisticsDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<Map<String, Integer>> getCountStatistics(Payload payload) {

        String name = payload.getName();
        String password = payload.getPassword();

        User user = userDao.findByNameAndPassword(name, password);

        if (user == null) {
            throw new ThereIsNoSuchUserException("There is not such user");
        }

        String signature = CreateSignature.createSign(payload);
        if (!payload.getSignature().equals(signature)) {
            throw new ThereIsNoSuchUserSignatureException("There is not such user's signature");
        }

        return statisticsDao.findByUserName(name);
    }
}
