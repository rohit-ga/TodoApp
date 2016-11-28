package com.todoapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.todoapp.bean.Task;
import com.todoapp.dao.impl.TaskDaoImpl;
import com.todoapp.service.ITaskService;

public class TaskServiceImpl implements ITaskService {

    public void createTask(Task task, int uid) throws SQLException {

        TaskDaoImpl taskDao = new TaskDaoImpl();
        taskDao.createTask(task, uid);

    }

    public List<Task> viewAllTasks() throws SQLException {

        TaskDaoImpl taskDao = new TaskDaoImpl();
        List<Task> taskList = taskDao.viewAllTask();

        return taskList;
    }

    public List<Task> getTaskByUserId(int uid) throws SQLException {

        TaskDaoImpl taskDao = new TaskDaoImpl();
        List<Task> taskList = taskDao.getTaskByUserId(uid);
        return taskList;
    }

}
