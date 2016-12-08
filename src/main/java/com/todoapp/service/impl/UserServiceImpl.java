package com.todoapp.service.impl;

import java.sql.SQLException;
import com.todoapp.dao.impl.UserDaoImpl;
import com.todoapp.model.User;
import com.todoapp.service.IUserService;

public class UserServiceImpl implements IUserService {

    UserDaoImpl userDao = new UserDaoImpl();

    public boolean registerUser(User user) throws SQLException {
        return userDao.registerUser(user);
    }

    public boolean addUser(User user) throws SQLException {
        return userDao.addUser(user);
    }

    public boolean loginUser(String userName, String password) throws SQLException {
        return userDao.loginUser(userName,password);
    }

    public User getUserIdByMail(String email) throws SQLException {
        User dbUser = userDao.getUserIdByMail(email);
        return dbUser;
    }

    public User getUserFname() throws SQLException {
        User dbUserFname = userDao.getUserFname();
        return dbUserFname;
    }
}
