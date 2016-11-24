package com.todoapp.dao;

import java.sql.SQLException;

import com.todoapp.bean.Task;

public interface ITaskDao {

    public void createTask(Task task,int uid) throws SQLException;
}
