package net.sometest.springsecurityapp.service;

import net.sometest.springsecurityapp.model.User;

public interface UserService {

    void save(User user);

    User findByUserName(String username);
}