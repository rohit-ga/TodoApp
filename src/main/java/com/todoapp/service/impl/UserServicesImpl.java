package com.todoapp.service.impl;

import java.sql.SQLException;

import com.todoapp.bean.User;
import com.todoapp.dao.impl.UserDaoImpl;
import com.todoapp.service.IUserService;

public class UserServicesImpl implements IUserService {

    UserDaoImpl userDao = new UserDaoImpl();

    public String registerUser(User user) throws SQLException {

        return userDao.registerUser(user);

    }

    public String addUser(User user) throws SQLException {
        
        return userDao.addUser(user);

    }

}
