package com.linkshortener.dao.impl;

import com.linkshortener.dao.LinkDao;
import com.linkshortener.exception.ThereIsNotFoundSuchShortUrlException;
import com.linkshortener.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class LinkDaoImpl implements LinkDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveShortUrl(Link link, Long userId) {
        return jdbcTemplate.update("INSERT INTO linkshortener.links " +
                        "(url, short_url, exp_dt, created_by) VALUES (?,?,?,?)",
                link.getUrl(), link.getShortUrl(), link.getExpDate(), userId);
    }

    @Override
    public Link findLinkByShortUrl(String shortUrl) {
        try {
            Link link = jdbcTemplate.queryForObject("SELECT "
                            + " id, url, short_url, created_dt as createdDate, exp_dt as expDate, created_by as userId "
                            + " FROM linkshortener.links WHERE short_url=?",
                    BeanPropertyRowMapper.newInstance(Link.class), shortUrl);

            if (link != null && LocalDateTime.now().isAfter(link.getExpDate())) {
                throw new ThereIsNotFoundSuchShortUrlException("Not Found Such Short Url");
            } else {
                return link;
            }
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteLinkByShortUrl(String shortUrl) {
        return jdbcTemplate.update("delete from  linkshortener.links where short_url = ?", shortUrl);
    }
}
