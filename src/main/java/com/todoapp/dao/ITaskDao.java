package com.todoapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.todoapp.bean.Task;

public interface ITaskDao {

    public void createTask(Task task, int uid) throws SQLException;

    public List<Task> viewAllTask() throws SQLException;

    public List<Task> getTaskByUserId(int uid) throws SQLException;
}
