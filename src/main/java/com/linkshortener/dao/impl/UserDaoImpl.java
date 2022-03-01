package com.linkshortener.dao.impl;

import com.linkshortener.dao.UserDao;
import com.linkshortener.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveUser(User user) {
        return jdbcTemplate.update("INSERT INTO linkshortener.users " +
                        "(name, password) VALUES (?,?)",
                user.getName(), user.getPassword());
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        return jdbcTemplate.queryForObject("select * from linkshortener.users where name = ? and password = ?" ,
                BeanPropertyRowMapper.newInstance(User.class),name, password);

    }

    @Override
    public int deleteUserByName(String name) {
        return jdbcTemplate.update("delete from  linkshortener.users where name = ?", name);
    }


}
