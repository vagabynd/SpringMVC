package com.evgen.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:com/evgen/dao/resources/sql.properties")

public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/evgen?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("26121997");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;
    }

}