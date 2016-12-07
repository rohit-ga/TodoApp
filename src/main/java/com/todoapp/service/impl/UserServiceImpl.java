package com.todoapp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.todoapp.dao.impl.UserDaoImpl;
import com.todoapp.model.User;
import com.todoapp.model.UserRole;
import com.todoapp.service.IUserService;

public class UserServiceImpl implements IUserService {

    UserDaoImpl userDao = new UserDaoImpl();

    public String registerUser(User user) throws SQLException {
        return userDao.registerUser(user);
    }

    public String addUser(User user) throws SQLException {
        return userDao.addUser(user);
    }

    public String loginUser(User user) throws SQLException {
        return userDao.loginUser(user);
    }

    public User getUserIdByMail(String email) throws SQLException {
        User dbUser = userDao.getUserIdByMail(email);
        return dbUser;
    }
    
    public User getUserFname() throws SQLException {
        User dbUserFname = userDao.getUserFname();
        return dbUserFname;
    }

    public UserRole authenticateUser(User user) throws SQLException {
        UserRole dbRole = userDao.authenticateUser(user);
        return dbRole;
    }
}
