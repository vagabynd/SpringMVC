package com.evgen;
import com.evgen.entity.User;
import com.evgen.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringTestConfig.class})
@Transactional
public class AppTest {

    private static final Logger LOGGER = LogManager.getLogger(AppTest.class.getName());

    @Autowired
    private UserService service;

    @Test
    public void getAllUsers() throws Exception {
        LOGGER.debug("test: findAll()");
        List<User> list = service.findAll();
        LOGGER.debug("test: findAll() = " + list.size());
        assertTrue(list.size() == 5);
    }

    @Test
    public void getUserById() throws Exception {
        LOGGER.debug("test: getById()");
        User user = service.getById(1);
        LOGGER.debug("test: getById() = " + user.getName());
        assertEquals("Evgen", user.getName());
    }

    @Test
    public void saveDb() throws Exception {
        LOGGER.debug("test: save()");
        User user = new User ("pidor", "asd", 15);
        service.save(user);
        List<User> list = service.findAll();
        LOGGER.debug("test: save() = " + list.size());
        assertTrue(list.size() == 6);
    }

    @Test
    public void deleteTest() throws Exception {
        LOGGER.debug("test: delete()");
        service.delete(5);
        List<User> list = service.findAll();
        LOGGER.debug("test: delete() = " + list.size());
        assertTrue(list.size() == 4);
    }

    @Test
    public void updateTest() throws Exception {
        LOGGER.debug("test: update()");
        LOGGER.debug("test: update() = " + service.getById(5).getName());
        User user = new User (5,"pidor", "asd", 15);
        service.update(user);
        User updUser = service.getById(5);
        LOGGER.debug("test: update() = " + updUser.getName());
        assertEquals("pidor", updUser.getName());
    }

    @Test
    public void test_always_return_true() {

        assert true;
    }
}

