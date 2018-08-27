package com.evgen;

import com.evgen.dao.UserDao;
import com.evgen.dao.UserDaoImpl;
import com.evgen.service.UserServiceImpl;
import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class AppTestMockConfig {

    @Bean
    public UserDao userDao() {
       return EasyMock.createMock(UserDaoImpl.class);
    }

    @Bean
    public UserServiceImpl userService(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.userDao = userDao();
        return userService;
    }
}
