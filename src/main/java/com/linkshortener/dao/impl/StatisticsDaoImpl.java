package com.linkshortener.dao.impl;

import com.linkshortener.dao.StatisticsDao;
import com.linkshortener.model.Link;
import com.linkshortener.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StatisticsDaoImpl implements StatisticsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveStatistics(Statistics statistics) {
        return jdbcTemplate.update("INSERT INTO linkshortener.statistics " +
                        "(short_link, opened_dt, cnt) VALUES (?,now(), 1)",
                statistics.getShortUrl());
    }

    @Override
    public List<Statistics> findByLink(Link link) {
        try {
            return jdbcTemplate.query("SELECT * FROM linkshortener.statistics WHERE link_id = ?",
                    new BeanPropertyRowMapper<Statistics>(Statistics.class), link.getId());

        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Map<String, Integer>> findByUserName(String name) {
        try {
            return jdbcTemplate.query("select short_link, sum(cnt) from ( " +
                    " SELECT s.short_link, s.cnt, u.name " +
                    " FROM linkshortener.statistics s join linkshortener.links l on s.short_link=l.short_url " +
                    " join linkshortener.users u on u.id = l.created_by " +
                    ") a where a.name = ? " +
                    "group by a.short_link ", rs -> {
                        List<Map<String, Integer>> list = new ArrayList<>();
                        while (rs.next()) {
                            HashMap<String, Integer> mapRet = new HashMap<>();
                            mapRet.put(rs.getString(1), rs.getInt(2));
                            list.add(mapRet);
                        }

                        return list;
                    }, name);

        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
