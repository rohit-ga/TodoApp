package com.todoapp.dao;

import java.sql.SQLException;

import com.todoapp.bean.User;

public interface IUserDao {

    public String registerUser(User user) throws SQLException;

    public String addUser(User user) throws SQLException;

    public String loginUser(User user) throws SQLException;

    public User getUserIdByMail(String email) throws SQLException;
}
