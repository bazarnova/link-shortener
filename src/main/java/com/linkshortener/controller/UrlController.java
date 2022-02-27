package com.linkshortener.controller;

import com.linkshortener.exception.ExceptionJson;
import com.linkshortener.exception.ThereIsNotFoundSuchShortUrlException;
import com.linkshortener.model.Something;
import com.linkshortener.model.Url;
import com.linkshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    UrlService urlService;

    @RequestMapping(method = RequestMethod.GET, value = "/{shortLink}")
    public void getLongUrl(HttpServletResponse httpServletResponse, HttpServletRequest request, @PathVariable String shortLink) throws IOException {
        Url url = urlService.getUrlByShortLink(shortLink);
        String longUrl = url.getLongUrl();
        httpServletResponse.sendRedirect(longUrl);

    }

    @RequestMapping( method = RequestMethod.POST, value = "url")
    @ResponseBody
    public Url createUrl(@RequestBody Something something) {

        Url url = new Url();
        url.setLongUrl(something.getLongUrl());
        url.setToDeleteDate(something.getToDeleteDate());

        return urlService.createUrl(url);
    }

    @ExceptionHandler(ThereIsNotFoundSuchShortUrlException.class)
    public ResponseEntity<ExceptionJson> handleThereIsNotFoundSuchShortUrlException(Exception ex) {

        return ResponseEntity.status(404).body(new ExceptionJson(ex.getMessage()));
    }

//
//    public void deleteShortUrl(String shortUrl) {
//        urlService.deleteByShortUrl(shortUrl);
//    }

}
