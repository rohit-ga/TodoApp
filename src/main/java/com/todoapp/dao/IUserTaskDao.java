package com.todoapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.todoapp.model.UserTask;
import com.todoapp.model.UserTaskDto;

public interface IUserTaskDao {

    public void addWorklog(UserTask userTask, int taskId, int userId) throws SQLException;
    
    public List<UserTaskDto> checkWorklogsOnMyTask(int taskId) throws SQLException;
    
    public List<UserTaskDto> checkWorklogsOfAllTask(int taskId) throws SQLException;
    
}
