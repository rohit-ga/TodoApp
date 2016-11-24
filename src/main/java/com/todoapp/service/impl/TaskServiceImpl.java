package com.todoapp.service.impl;

import java.sql.SQLException;

import com.todoapp.bean.Task;
import com.todoapp.dao.impl.TaskDaoImpl;
import com.todoapp.service.ITaskService;

public class TaskServiceImpl implements ITaskService {

    public void createTask(Task task,int uid) throws SQLException {
        
        TaskDaoImpl taskDao = new TaskDaoImpl();
        taskDao.createTask(task,uid);
        
    }

}
