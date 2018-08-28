package com.evgen.rest;

import com.evgen.entity.User;
import com.evgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserControllerRest {

    private static final String VERSION = "1.0";

    @Qualifier("userServiceImpl")
    @Autowired
    UserService service;

    @GetMapping(value = "/version")
    public String getVersion() {
        System.out.println(VERSION);
        return VERSION;
    }

    @GetMapping(value = "/users")
    public
    @ResponseBody
    List<User> getStudents() {
        return service.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public
    @ResponseBody
    User getStudentById(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }


}
