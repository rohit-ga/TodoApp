package com.todoapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todoapp.dao.IUserDao;
import com.todoapp.model.User;
import com.todoapp.model.UserRole;
import com.todoapp.util.DatabaseConnection;

public class UserDaoImpl implements IUserDao {

    static Connection connection;

    static {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String registerUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email = ?");
        pst.setString(1, user.getUserEmail());

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return "You have already registerd with this email";
        } else {
            return addUser(user);
        }
    }

    public String addUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
        pst.setInt(1, user.getUserId());
        pst.setString(2, user.getUserFname());
        pst.setString(3, user.getUserLname());
        pst.setString(4, user.getUserGender());
        pst.setString(5, user.getUserContact());
        pst.setString(6, user.getUserEmail());
        pst.setString(7, user.getUserPassword());
        pst.executeUpdate();
        return "You are successfully registered ";
    }

    public String loginUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email=? and password=?");
        pst.setString(1, user.getUserEmail());
        pst.setString(2, user.getUserPassword());

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return "You have login successfully";
        } else {
            return "Email or Password is not correct";
        }
    }

    public User getUserIdByMail(String email) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email = ?");
        pst.setString(1, email);

        ResultSet rs = pst.executeQuery();
        User dbUser = new User();
        while (rs.next()) {
            dbUser.setUserId(rs.getInt("uid"));
        }
        return dbUser;
    }

    public User getUserFname() throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select firstname from user");
        //pst.setString(1, email);

        ResultSet rs = pst.executeQuery();
        User dbUserFname = new User();
        while (rs.next()) {
            dbUserFname.setUserFname(rs.getString("firstname"));
        }
        return dbUserFname;
    }

    public UserRole authenticateUser(User user) throws SQLException {
        
        PreparedStatement pst = connection.prepareStatement("select * from user where email=? and password=?");
        pst.setString(1, user.getUserEmail());
        pst.setString(2, user.getUserPassword());
        
        ResultSet rs = pst.executeQuery();
        UserRole dbRole = new UserRole();
        if (rs.next()){
            dbRole.getRoleId();
            System.out.println("dbRole:::" + dbRole);
            return dbRole;
        } else {
            return null;
        }
    }
}