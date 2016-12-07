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

    UserTask userTask = new UserTask();
    UserTaskServiceImpl userTaskService = new UserTaskServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    TaskServiceImpl taskService = new TaskServiceImpl();
    User user = new User();
    Task task = new Task();
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
        System.out.println("Action in UserTaskController::::" + action);
        if (action.equals("worklog")) {
            addWorklog(request, response);
        } else if (action.equals("view")) {
            checkWorklogsOnMyTask(request, response);
        }
    }

    private void checkWorklogsOnMyTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.getAttribute("email");

        Integer taskId = Integer.parseInt(request.getParameter("taskId"));
        Task dbTaskName = taskService.getTaskNameById(taskId);
               
        List<UserTaskDto> worklogs = userTaskService.checkWorklogsOnMyTask(taskId);
        request.setAttribute("worklogs", worklogs);
        request.setAttribute("taskName", dbTaskName.getTaskName());

        RequestDispatcher view = request.getRequestDispatcher("viewtaskworklog.jsp");
        view.include(request, response);
    }

    private void addWorklog(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        User dbUser = userService.getUserIdByMail(email);
        Integer taskId = Integer.parseInt(request.getParameter("taskId"));

        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String description = request.getParameter("description");
        userTask.setStartTime(startTime);
        userTask.setEndTime(endTime);
        userTask.setDescription(description);

        userTaskService.addWorklog(userTask, taskId, dbUser.getUserId());

        allTaskList = taskService.viewAllTasks();
        request.setAttribute("allTaskList", allTaskList);

        RequestDispatcher view = request.getRequestDispatcher("alltask.jsp");
        view.forward(request, response);
    }
}
