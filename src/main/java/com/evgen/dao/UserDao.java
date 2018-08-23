package com.evgen.dao;

import com.evgen.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
}