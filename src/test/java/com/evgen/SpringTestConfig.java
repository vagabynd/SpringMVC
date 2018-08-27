package com.evgen;

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
@ComponentScan(basePackages = "com.evgen")
@PropertySource("classpath:com/evgen/dao/resources/sql.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement

public class SpringTestConfig {


    @Bean
    public JdbcTemplate getJdbcTemplate() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }


    @Bean
    public DataSource getDataSource() {

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

        return new DataSourceTransactionManager(getDataSource());
    }
}