package com.todoapp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todoapp.dao.impl.UserTaskDaoImpl;
import com.todoapp.model.UserTask;
import com.todoapp.model.UserTaskDto;
import com.todoapp.service.IUserTaskService;

public class UserTaskServiceImpl implements IUserTaskService {

    UserTaskDaoImpl userTaskDao = new UserTaskDaoImpl();
    List<UserTaskDto> worklogs = new ArrayList<UserTaskDto>();

    public void addWorklog(UserTask userTask, int taskId, int userId) throws SQLException {

        userTaskDao.addWorklog(userTask, taskId, userId);
    }

    public List<UserTaskDto> checkWorklogsOnMyTask(int taskId) throws SQLException {

        worklogs = userTaskDao.checkWorklogsOnMyTask(taskId);
        return worklogs;
    }
}