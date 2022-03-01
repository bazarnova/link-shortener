package com.linkshortener.controller;

import com.linkshortener.exception.ExceptionJson;
import com.linkshortener.exception.ThereIsNoSuchUserSignatureException;
import com.linkshortener.exception.ThereIsNotFoundSuchShortUrlException;
import com.linkshortener.model.Link;
import com.linkshortener.model.Payload;
import com.linkshortener.service.LinkCreateService;
import com.linkshortener.service.LinkDeleteService;
import com.linkshortener.service.LinkGetService;
import com.linkshortener.service.StatisticsGetCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LinkController {

    @Autowired
    LinkCreateService linkCreateService;

    @Autowired
    LinkGetService linkGetService;

    @Autowired
    LinkDeleteService linkDeleteService;

    @Autowired
    StatisticsGetCountService statisticsGetCountService;

    @RequestMapping(method = RequestMethod.GET, value = "/{shortUrl}")
    public void getUrl(HttpServletResponse httpServletResponse, HttpServletRequest request, @PathVariable String shortUrl) throws IOException {
        Link link = linkGetService.getLinkByShortUrl(shortUrl);
        String url = link.getUrl();
        httpServletResponse.sendRedirect(url);
    }

    @RequestMapping( method = RequestMethod.POST, value = "url")
    @ResponseBody
    public Link createUrl(@RequestBody Payload payload) {

        return linkCreateService.createLink(payload);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/statistic")
    @ResponseBody
    public List<Map<String, Integer>> getStatistics(@RequestBody Payload payload) throws IOException {
        return statisticsGetCountService.getCountStatistics(payload);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/{shortUrl}")
    public void deleteUrl(@PathVariable String shortUrl) {
        linkDeleteService.deleteByUrl(shortUrl);
    }

    @ExceptionHandler(ThereIsNotFoundSuchShortUrlException.class)
    public ResponseEntity<ExceptionJson> handleThereIsNotFoundSuchShortUrlException(Exception ex) {

        return ResponseEntity.status(404).body(new ExceptionJson(ex.getMessage()));
    }

    @ExceptionHandler(ThereIsNoSuchUserSignatureException.class)
    public ResponseEntity<ExceptionJson> handleThereIsNoSuchUserSignatureException(Exception ex) {

        return ResponseEntity.status(404).body(new ExceptionJson(ex.getMessage()));
    }

}
