package net.sometest.springsecurityapp.service;

import net.sometest.springsecurityapp.dao.RoleDao;
import net.sometest.springsecurityapp.dao.UserDao;
import net.sometest.springsecurityapp.model.Role;
import net.sometest.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getRole(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    @Transactional
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
