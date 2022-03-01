package com.linkshortener.service.impl;

import com.linkshortener.dao.LinkDao;
import com.linkshortener.dao.UserDao;
import com.linkshortener.exception.ThereIsNoSuchUserException;
import com.linkshortener.exception.ThereIsNoSuchUserSignatureException;
import com.linkshortener.model.Link;
import com.linkshortener.model.Payload;
import com.linkshortener.model.User;
import com.linkshortener.service.LinkCreateService;
import com.linkshortener.util.CreateSignature;
import com.linkshortener.util.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkCreateServiceImpl implements LinkCreateService {

    @Autowired
    private ShortUrlGenerator generator;

    @Autowired
    private LinkDao linkDao;

    @Autowired
    UserDao userDao;

    @Override
    public Link createLink(Payload payload) {

        String name = payload.getName();
        String password = payload.getPassword();

        User user = userDao.findByNameAndPassword(name, password);
        Long userId = user.getId();

        if (user == null) {
            throw new ThereIsNoSuchUserException("There is not such user");
        }

        String signature = CreateSignature.createSign(payload);
        if (!payload.getSignature().equals(signature)) {
            throw new ThereIsNoSuchUserSignatureException("There is not such user's signature");
        }

        Link link = new Link();
        link.setUrl(payload.getUrl());
        link.setExpDate(payload.getExpDate());



        int shortUrlLength = 6;
        String generatedUrl = generator.generate(shortUrlLength);
        link.setShortUrl(generatedUrl);
        linkDao.saveShortUrl(link, userId);
        return link;
    }
}
