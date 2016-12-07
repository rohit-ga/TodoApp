package com.todoapp.service;

import java.sql.SQLException;

import com.todoapp.model.User;

public interface IUserService {

    public String registerUser(User user) throws SQLException;

    public String addUser(User user) throws SQLException;
    
    public String loginUser(User user) throws SQLException;
    
    public User getUserIdByMail(String email) throws SQLException;

}
