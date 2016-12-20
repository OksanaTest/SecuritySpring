package net.sometest.springsecurityapp.dao;

import net.sometest.springsecurityapp.model.User;

public interface UserDao {

    void save(User user);

    User findByUserName(String username);
}