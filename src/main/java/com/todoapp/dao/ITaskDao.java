package com.todoapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.todoapp.model.Task;

public interface ITaskDao {

    public void createTask(String taskName, int userId) throws SQLException;

    public List<Task> viewAllTask() throws SQLException;

    public List<Task> getTaskByUserId(int userId) throws SQLException;
}
