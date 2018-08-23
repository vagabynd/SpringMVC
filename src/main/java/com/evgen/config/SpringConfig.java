package com.evgen.config;

import com.evgen.dao.UserDao;
import com.evgen.dao.UserDaoImpl;
import com.evgen.service.UserService;
import com.evgen.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
    //настройки бд
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/evgen?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("26121997");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
    //реализация dao
    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
