package com.evgen;

import com.evgen.dao.UserDao;
import com.evgen.dao.UserDaoImpl;
import com.evgen.service.UserService;
import com.evgen.service.UserServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:com/evgen/dao/resources/sql.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement

public class SpringTestConfig {


    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSourceTest());
    }

    @Bean
    public DataSource getDataSourceTest() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-tables.sql")
                .addScript("data-script.sql")
                .build();

        return db;
    }

    @Bean
    public PlatformTransactionManager txManager() {

        return new DataSourceTransactionManager(getDataSourceTest());
    }

    @Bean
    public UserDao getUserDao(){
        UserDao userDao = new UserDaoImpl(getJdbcTemplate());
        return userDao;
    }

    @Bean
    public UserService getUserService(){
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).userDao = getUserDao();
        return userService;
    }
}