package com.asteroid.pncode.service;

import com.asteroid.pncode.dao.UserDao;
import com.asteroid.pncode.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YuSai
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getByUserName(String userName) {
        return userDao.findByUsername(userName);
    }

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }
}
