package com.example.man.dao;

import com.example.man.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAll() throws SQLException;

    List<User> getOne(int id) throws SQLException;

     void create(User user) throws  SQLException;
    void update(User user, String id) throws SQLException;
    public int delete(int id) throws SQLException;

}
