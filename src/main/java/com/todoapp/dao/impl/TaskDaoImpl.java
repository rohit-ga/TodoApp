package com.todoapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todoapp.dao.ITaskDao;
import com.todoapp.model.Task;
import com.todoapp.util.DatabaseConnection;

public class TaskDaoImpl implements ITaskDao {

    static Connection connection;
    List<Task> allTaskList = new ArrayList<Task>();
    List<Task> myTaskList = new ArrayList<Task>();

    {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTask(Task task, int dbUser) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into taskdetails values(?,?,?,?)");
        pst.setInt(1, task.getTaskId());
        pst.setString(2, task.getTaskName());
        pst.setDate(3, new java.sql.Date(task.getTaskCreationDate().getTime()));
        pst.setInt(4, dbUser);
        pst.executeUpdate();
    }

    public List<Task> viewAllTask() throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from taskdetails ");

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {

            Task dbTask = new Task();
            dbTask.setTaskId(rs.getInt("taskid"));
            dbTask.setTaskName(rs.getString("taskname"));
            dbTask.setTaskCreationDate(rs.getDate("task_creationdate"));
            allTaskList.add(dbTask);
        }
        return allTaskList;
    }

    public List<Task> getTaskByUserId(int dbUser) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("select * from taskdetails where uid = ?");
        pst.setInt(1, dbUser);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {

            Task dbTask = new Task();
            dbTask.setTaskId(rs.getInt("taskid"));
            dbTask.setTaskName(rs.getString("taskname"));
            dbTask.setTaskCreationDate(rs.getDate("task_creationdate"));
            myTaskList.add(dbTask);
        }
        return myTaskList;
    }

    public Task getTaskNameById(int taskid) throws SQLException {
        PreparedStatement pst = connection.prepareStatement("select taskname from taskdetails where taskid=?");
        pst.setInt(1, taskid);

        Task dbTaskName = new Task();
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            dbTaskName.setTaskName(rs.getString("taskname"));
        }
        return dbTaskName;
    }
}