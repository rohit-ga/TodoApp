package com.todoapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import com.todoapp.service.impl.TaskServiceImpl;
import com.todoapp.service.impl.UserServiceImpl;

@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    User user = new User();
    UserServiceImpl userService = new UserServiceImpl();
    TaskServiceImpl taskService = new TaskServiceImpl();
    List<Task> allTaskList = new ArrayList<Task>();
    List<Task> myTaskList = new ArrayList<Task>();

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

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println("action of task controller:::" + action);
        if (action.equals("create")) {
            createTask(request, response);
        } else if (action.equals("alltasks")) {
            viewAllTask(request, response);
        } else if (action.equals("mytasks")) {
            getMyTask(request, response);
        } else if (action.equals("dashboard")) {
            taskCount(request, response);
        } else if (action.equals("add")) {
            redirectToWorklogPage(request, response);
        } 
    }

    private void redirectToWorklogPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        
        if(email == null){
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        } else {
            //request.getParameter("taskId");
            request.setAttribute("taskId", request.getParameter("taskId"));
            RequestDispatcher view = request.getRequestDispatcher("worklog.jsp");
            view.forward(request, response);
        }
    }

    private void taskCount(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        allTaskList = taskService.viewAllTasks();
        User dbUser = userService.getUserIdByMail(email);
        myTaskList = taskService.getTaskByUserId(dbUser.getUserId());

        int allTask = allTaskList.size();
        request.setAttribute("allTask", allTask);

        int myTask = myTaskList.size();
        request.setAttribute("myTask", myTask);

        RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request, response);
        //response.sendRedirect(request.getContextPath() + "/UserController?action=success");
    }

    private void getMyTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        User dbuser = userService.getUserIdByMail(email);

        myTaskList = taskService.getTaskByUserId(dbuser.getUserId());
        request.setAttribute("myTaskList", myTaskList);

        //response.sendRedirect(request.getContextPath() + "/TaskController?action=dashboard");
        RequestDispatcher view = request.getRequestDispatcher("mytask.jsp");
        view.forward(request, response);
        //response.sendRedirect("mytask.jsp");
        //return myTaskList;
    }

    private void createTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        String taskname = request.getParameter("taskname");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        User dbUser = userService.getUserIdByMail(email);

        Task task = new Task();
        task.setTaskName(taskname);
        task.setTaskCreationDate(new Date());

        taskService.createTask(task, dbUser.getUserId());

        myTaskList = taskService.getTaskByUserId(dbUser.getUserId());
        request.setAttribute("myTaskList", myTaskList);

        /*RequestDispatcher view = request.getRequestDispatcher("mytask.jsp");
        view.include(request, response);*/
        response.sendRedirect(request.getContextPath() + "/TaskController?action=mytasks");
    }

    private void viewAllTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
        
        HttpSession session = request.getSession();
        session.getAttribute("email");

        allTaskList = taskService.viewAllTasks();
        request.setAttribute("allTaskList", allTaskList);

        RequestDispatcher view = request.getRequestDispatcher("alltask.jsp");
        view.include(request, response);
        
        //response.sendRedirect(request.getContextPath() + "/TaskController?action=alltasks");
        //return allTaskList;
    }
}
