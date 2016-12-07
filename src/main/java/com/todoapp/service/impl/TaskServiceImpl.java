package com.todoapp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todoapp.dao.impl.TaskDaoImpl;
import com.todoapp.model.Task;
import com.todoapp.service.ITaskService;

public class TaskServiceImpl implements ITaskService {

    TaskDaoImpl taskDao = new TaskDaoImpl();
    List<Task> allTaskList = new ArrayList<Task>();
    List<Task> myTaskList = new ArrayList<Task>();

    public void createTask(Task task, int dbUser) throws SQLException {
        taskDao.createTask(task, dbUser);
    }

    public List<Task> viewAllTasks() throws SQLException {
        allTaskList = taskDao.viewAllTask();
        return allTaskList;
    }

    public List<Task> getTaskByUserId(int dbUser) throws SQLException {
        myTaskList = taskDao.getTaskByUserId(dbUser);
        return myTaskList;
    }
    
    public Task getTaskNameById(int taskid) throws SQLException {
        Task dbTaskName = taskDao.getTaskNameById(taskid);
        return dbTaskName;
    }
}