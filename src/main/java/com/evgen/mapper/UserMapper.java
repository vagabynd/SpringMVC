package com.evgen.mapper;

import com.evgen.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setAge(resultSet.getInt("age"));
        user.setEmail(resultSet.getString("email"));
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));

        return user;
    }
}