package com.todoapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todoapp.dao.IUserTaskDao;
import com.todoapp.model.UserTask;
import com.todoapp.model.UserTaskDto;
import com.todoapp.util.DatabaseConnection;

public class UserTaskDaoImpl implements IUserTaskDao {

    static Connection connection;

    {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addWorklog(UserTask userTask, int taskId, int userId) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into user_task values(?,?,?,?,?,?)");
        pst.setInt(1, userId);
        pst.setInt(2, taskId);
        pst.setString(3, userTask.getStartTime());
        pst.setString(4, userTask.getEndTime());
        pst.setString(5, userTask.getDescription());
        pst.setInt(6, 0);
        pst.executeUpdate();
    }

    public List<UserTaskDto> checkWorklogsOnMyTask(int taskId) throws SQLException {

        PreparedStatement pst = connection
                .prepareStatement("select firstname,start_time,end_time,description from user_task join user on user.uid = user_task.uid where taskid=?");
        pst.setInt(1, taskId);
        List<UserTaskDto> worklogs = new ArrayList<UserTaskDto>();
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            UserTaskDto dbUserTaskDto = new UserTaskDto();
            dbUserTaskDto.setUserFname(rs.getString("firstname"));
            dbUserTaskDto.setStartTime(rs.getString("start_time"));
            dbUserTaskDto.setEndTime(rs.getString("end_time"));
            dbUserTaskDto.setDescription(rs.getString("description"));
            worklogs.add(dbUserTaskDto);
        }
        return worklogs;
    }

    public List<UserTaskDto> checkWorklogsOfAllTask(int taskId) throws SQLException {

        PreparedStatement pst = connection
                .prepareStatement("select firstname,start_time,end_time,description from user_task join user on user.uid = user_task.uid");
        List<UserTaskDto> worklogs = new ArrayList<UserTaskDto>();
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            UserTaskDto dbUserTaskDto = new UserTaskDto();
            dbUserTaskDto.setUserFname(rs.getString("firstname"));
            dbUserTaskDto.setStartTime(rs.getString("start_time"));
            dbUserTaskDto.setEndTime(rs.getString("end_time"));
            dbUserTaskDto.setDescription(rs.getString("description"));
            worklogs.add(dbUserTaskDto);
        }
        return worklogs;
    }
}
