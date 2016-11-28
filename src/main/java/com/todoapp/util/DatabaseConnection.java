package com.todoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/todoapp", "username", "password");

            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Error in Connection:-" + e.getException());
            e.printStackTrace();
        }
        return null;

    }
}
