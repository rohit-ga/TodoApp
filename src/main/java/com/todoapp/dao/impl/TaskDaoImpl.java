package com.todoapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.todoapp.bean.Task;

import com.todoapp.dao.ITaskDao;
import com.todoapp.util.DatabaseConnection;

public class TaskDaoImpl implements ITaskDao {

    static Connection connection;

    {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTask(Task task,int uid) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into taskdetails values(?,?,?,?)");
        
        pst.setInt(1, task.getTaskId());
        pst.setString(2, task.getTaskName());
        pst.setDate(3, new java.sql.Date(task.getTaskCreationDate().getTime()));
        pst.setInt(4, uid);

        pst.executeUpdate();
    }

}
