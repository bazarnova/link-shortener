package com.linkshortener.dao;

import com.linkshortener.exception.ThereIsNotFoundSuchShortUrlException;
import com.linkshortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class UrlDaoImpl implements UrlDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveShortUrl(Url url) {


        return jdbcTemplate.update("INSERT INTO linkshortener.urls " +
                        "(long_url, short_url, to_delete_date) VALUES (?,?,?)",
                url.getLongUrl(), url.getShortUrl(), url.getToDeleteDate());
    }

    @Override
    public Url findUrlByShortLink(String shortLink) {
        try {
            Url url = jdbcTemplate.queryForObject("SELECT * FROM linkshortener.urls WHERE short_url=?",
                    BeanPropertyRowMapper.newInstance(Url.class), shortLink);

            if(url != null && url.getToDeleteDate().isBefore(LocalDateTime.now())){
                throw  new ThereIsNotFoundSuchShortUrlException("Not Found Such Short Url");
            } else {
                return url;
            }
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteUrlByShortUrl(String shortLink) {
        return jdbcTemplate.update("delete from  linkshortener.urls where short_url = ?", shortLink);
    }
}
