package com.evgen.config;

import org.springframework.context.annotation.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:com/evgen/dao/resources/sql.properties")
@ComponentScan(basePackages = "com.evgen")

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