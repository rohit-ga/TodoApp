package com.todoapp.service;

import java.sql.SQLException;

import com.todoapp.bean.User;

public interface IUserService {

    public String registerUser(User user) throws SQLException;

    public String addUser(User user) throws SQLException;

}
