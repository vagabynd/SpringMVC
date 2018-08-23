package com.evgen.dao;

import com.evgen.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);

    List<User> findAll();
}