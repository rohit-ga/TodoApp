package com.todoapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todoapp.dao.IUserDao;
import com.todoapp.model.User;
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

    public boolean registerUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email = ?");
        pst.setString(1, user.getUserEmail());

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return false;
        } else {
            return addUser(user);
        }
    }

    public boolean addUser(User user) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
        pst.setInt(1, 0);
        pst.setString(2, user.getUserFname());
        pst.setString(3, user.getUserLname());
        pst.setString(4, user.getUserGender());
        pst.setString(5, user.getUserContact());
        pst.setString(6, user.getUserEmail());
        pst.setString(7, user.getUserPassword());
        pst.setInt(8, user.getRoleId());
        pst.executeUpdate();
        return true;
    }

    public boolean loginUser(String email, String password) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email=? and password=?");
        pst.setString(1, email);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public User getUserIdByMail(String email) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from user where email = ?");
        pst.setString(1, email);

        ResultSet rs = pst.executeQuery();
        User dbUser = new User();
        while (rs.next()) {
            dbUser.setUserId(rs.getInt("uid"));
            dbUser.setRoleId(rs.getInt("roleid"));
        }
        return dbUser;
    }

    public User getUserFname() throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select firstname from user");

        ResultSet rs = pst.executeQuery();
        User dbUserFname = new User();
        while (rs.next()) {
            dbUserFname.setUserFname(rs.getString("firstname"));
        }
        return dbUserFname;
    }
}