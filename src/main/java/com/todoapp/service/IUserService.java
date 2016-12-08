package com.todoapp.service;

import java.sql.SQLException;

import com.todoapp.model.User;

public interface IUserService {

    public boolean registerUser(User user) throws SQLException;

    public boolean addUser(User user) throws SQLException;

    public boolean loginUser(String email, String password) throws SQLException;

    public User getUserIdByMail(String email) throws SQLException;

}
