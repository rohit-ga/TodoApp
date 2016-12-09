package com.todoapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todoapp.model.Task;
import com.todoapp.model.User;
import com.todoapp.model.UserTask;
import com.todoapp.model.UserTaskDto;
import com.todoapp.service.impl.TaskServiceImpl;
import com.todoapp.service.impl.UserServiceImpl;
import com.todoapp.service.impl.UserTaskServiceImpl;

@WebServlet("/UserTaskController")
public class UserTaskController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    RequestDispatcher view;
    UserTask userTask = new UserTask();
    UserTaskServiceImpl userTaskService = new UserTaskServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    TaskServiceImpl taskService = new TaskServiceImpl();
    List<Task> allTaskList = new ArrayList<Task>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            doProcess(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {

        String action = request.getParameter("action");
        
        if (action.equals("worklog")) {
            addWorklog(request, response);
            
        } else if (action.equals("view")) {
            checkWorklogsOnMyTask(request, response);
            
        } else if (action.equals("check")) {
            checkWorklogsOfAllTask(request, response);
            
        }
    }

    private void checkWorklogsOfAllTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
//      to check all worklog of all users created by them.
        Integer taskId = Integer.parseInt(request.getParameter("taskId"));
        Task dbTaskName = taskService.getTaskNameById(taskId);
        
        List<UserTaskDto> worklogs = userTaskService.checkWorklogsOfAllTask(taskId);
        request.setAttribute("worklogs", worklogs);
        request.setAttribute("taskName", dbTaskName.getTaskName());

        request.getRequestDispatcher("allworklog.jsp").include(request, response);
    }

    private void checkWorklogsOnMyTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
//      To check all work logs on tasks that created by logged user
        HttpSession session = request.getSession();
        session.getAttribute("email");

        Integer taskId = Integer.parseInt(request.getParameter("taskId"));
        
//      getting taskname by taskid from taskdetails table
        Task dbTaskName = taskService.getTaskNameById(taskId);
               
        List<UserTaskDto> worklogs = userTaskService.checkWorklogsOnMyTask(taskId);
        request.setAttribute("worklogs", worklogs);
        request.setAttribute("taskName", dbTaskName.getTaskName());

        request.getRequestDispatcher("viewtaskworklog.jsp").include(request, response);
    }

    private void addWorklog(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
//      To add worklogs on any tasks
        HttpSession session = request.getSession();
        
//      getting userId by mail from user table
        User dbUser = userService.getUserIdByMail((String) session.getAttribute("email"));
        
        Integer taskId = Integer.parseInt(request.getParameter("taskId"));

        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String description = request.getParameter("description");
        userTask.setStartTime(startTime);
        userTask.setEndTime(endTime);
        userTask.setDescription(description);

        userTaskService.addWorklog(userTask, taskId, dbUser.getUserId());
        request.setAttribute("allTaskList", taskService.viewAllTasks());

        request.getRequestDispatcher("alltask.jsp").forward(request, response);
    }
}
