package com.evgen;


import com.evgen.dao.UserDao;
import com.evgen.entity.User;
import com.evgen.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppTestMockConfig.class})
public class AppTestMock {

    private static final Logger LOGGER = LogManager.getLogger(AppTestMock.class);

    @Qualifier("userService")
    @Autowired
    private UserService service;

    @Qualifier("userDao")
    @Autowired
    private UserDao mockDao;

    @After
    public void clean() {
        verify();
    }

    @Before
    public void setUp() {
        reset(mockDao);
    }


    @Test
    public void getByIdTestMock() throws Exception {
        LOGGER.debug("test: getById()");
        expect(mockDao.getById(1)).andReturn(new User(1,"gay", "das", 5));
        replay(mockDao);
        service.getById(1);
    }

}
