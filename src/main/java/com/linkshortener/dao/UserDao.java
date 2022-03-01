package com.linkshortener.dao;

import com.linkshortener.model.User;

public interface UserDao {

    int saveUser(User user);

    User findByNameAndPassword(String name, String password);

    int deleteUserByName(String name);
}
