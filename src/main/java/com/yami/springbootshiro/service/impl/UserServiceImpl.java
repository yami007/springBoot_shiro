package com.yami.springbootshiro.service.impl;

import com.yami.springbootshiro.dao.UserDao;
import com.yami.springbootshiro.model.User;
import com.yami.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}


