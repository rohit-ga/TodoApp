package com.todoapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todoapp.bean.User;
import com.todoapp.dao.IUserDao;
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
        pst.setString(1, user.getUseremail());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return "You have already registerd with this email";
        } else {
            return addUser(user);
        }
    }

    public String addUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?)");

        pst.setInt(1, user.getUid());
        pst.setString(2, user.getUserfname());
        pst.setString(3, user.getUserlname());
        pst.setString(4, user.getUsergender());
        pst.setString(5, user.getUsercontact());
        pst.setString(6, user.getUseremail());
        pst.setString(7, user.getUserpassword());

        pst.executeUpdate();

        return "You are successfully registered ";
    }

    public String loginUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email=? and password=?");
        pst.setString(1, user.getUseremail());
        pst.setString(2, user.getUserpassword());

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

            dbUser.setUid(rs.getInt("uid"));
        }
        return dbUser;

    }

    

}
