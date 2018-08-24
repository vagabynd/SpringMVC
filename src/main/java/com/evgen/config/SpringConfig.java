package com.evgen.config;

import com.evgen.dao.UserDao;
import com.evgen.dao.UserDaoImpl;
import com.evgen.service.UserService;
import com.evgen.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.evgen.service", "com.evgen.dao"}) //где бины искать
@PropertySource("classpath:com/evgen/dao/resources/sql.properties")

public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
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


}
