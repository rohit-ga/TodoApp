package com.todoapp.dao;

import java.sql.SQLException;

import com.todoapp.model.User;

public interface IUserDao {

    public boolean registerUser(User user) throws SQLException;

    public boolean addUser(User user) throws SQLException;

    public boolean loginUser(String email, String password) throws SQLException;

    public User getUserIdByMail(String email) throws SQLException;
}