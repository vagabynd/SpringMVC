package com.evgen.dao;

import com.evgen.entity.User;
import com.evgen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @Value("${UserDaoSql.findAll}")
    String findAllSql;

    @Value("${UserDaoSql.update}")
    String updateSql;

    @Value("${UserDaoSql.getById}")
    String getByIdSql;

    @Value("${UserDaoSql.delete}")
    String deleteSql;

    @Value("${UserDaoSql.save}")
    String saveSql;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(saveSql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(getByIdSql, new UserMapper(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(deleteSql, id);
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(updateSql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(findAllSql, new UserMapper());
    }

}