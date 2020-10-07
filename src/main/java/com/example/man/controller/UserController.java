package com.example.man.controller;

import com.example.man.dao.UserDao;
import com.example.man.dao.UserDaoClass;

import com.example.man.model.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UserController {
    UserDao userDao;

    public UserController() {
        userDao = new UserDaoClass();
    }

    @RequestMapping(value = "/getall")
    String getAll() throws SQLException {
        return userDao.getAll().toString();
    }
    @GetMapping(value = "/getone/{id}")
    public String getOne(@PathVariable int id) throws SQLException {

        return userDao.getOne(id).toString();

    }
    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public void create(@RequestBody User user) throws SQLException {

        userDao.create(user);

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/put/{id}")
    public void update(@RequestBody User user, @PathVariable String id) throws SQLException {

        userDao.update(user, id);

    }
    @GetMapping(value = "/delete/{id}")
    public int ser(@PathVariable int id) throws SQLException {

        return userDao.delete(id);

    }

}