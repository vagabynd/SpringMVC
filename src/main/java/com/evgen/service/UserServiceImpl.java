package com.evgen.service;

import com.evgen.dao.UserDao;
import com.evgen.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    public UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Logging
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Logging
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Logging
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Logging
    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
