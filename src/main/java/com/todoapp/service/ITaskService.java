package com.todoapp.service;

import java.sql.SQLException;
import java.util.List;

import com.todoapp.bean.Task;

public interface ITaskService {

    public void createTask(Task task, int uid) throws SQLException;

    public List<Task> viewAllTasks() throws SQLException;

    public List<Task> getTaskByUserId(int uid) throws SQLException;
}
