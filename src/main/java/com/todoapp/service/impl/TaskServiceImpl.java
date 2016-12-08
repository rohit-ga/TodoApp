package com.todoapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.todoapp.dao.impl.TaskDaoImpl;
import com.todoapp.model.Task;
import com.todoapp.service.ITaskService;

public class TaskServiceImpl implements ITaskService {

    TaskDaoImpl taskDao = new TaskDaoImpl();

    public void createTask(String taskName, int dbUser) throws SQLException {
        taskDao.createTask(taskName, dbUser);
    }

    public List<Task> viewAllTasks() throws SQLException {
        return taskDao.viewAllTask();
    }

    public List<Task> getTaskByUserId(int dbUser) throws SQLException {
        return taskDao.getTaskByUserId(dbUser);
    }

    public Task getTaskNameById(int taskId) throws SQLException {
        return taskDao.getTaskNameById(taskId);
    }
}