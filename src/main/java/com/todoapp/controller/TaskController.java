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

    RequestDispatcher view;
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

        } else if (action.equals("getalltasks")) {
            viewAllTask(request, response);

        }
    }

    private void redirectToWorklogPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        if (email == null) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
            ;
        } else {
            request.setAttribute("taskId", request.getParameter("taskId"));
            request.getRequestDispatcher("worklog.jsp").forward(request, response);
        }
    }

    private void taskCount(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
        // task number counting on dashboard page
        HttpSession session = request.getSession(true);
        User dbUser = userService.getUserIdByMail((String) session.getAttribute("email"));

        request.setAttribute("allTask", taskService.viewAllTasks().size());
        request.setAttribute("myTask", taskService.getTaskByUserId(dbUser.getUserId()).size());
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        // response.sendRedirect(request.getContextPath() + "/UserController?action=success");
    }

    private void getMyTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
        // getting tasklist of logged user
        HttpSession session = request.getSession(true);
        User dbuser = userService.getUserIdByMail((String) session.getAttribute("email"));
        request.setAttribute("myTaskList", taskService.getTaskByUserId(dbuser.getUserId()));
        //response.sendRedirect(getServletContext().getContextPath() + "/TaskController?action=mytasks" + "/mytask.jsp");
        request.getRequestDispatcher("mytask.jsp").include(request, response);
    }

    private void createTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        // for creation of new task
        HttpSession session = request.getSession(true);

        User dbUser = userService.getUserIdByMail((String) session.getAttribute("email"));

        String taskName = request.getParameter("taskName");
        new Task(taskName, new Date());
        taskService.createTask(taskName, dbUser.getUserId());

        if (dbUser.getRoleId() == 1) {
            viewAllTask(request, response);
        } else {
            myTaskList = taskService.getTaskByUserId(dbUser.getUserId());
            request.setAttribute("myTaskList", myTaskList);
            response.sendRedirect(request.getContextPath() + "/TaskController?action=mytasks");
        }
    }

    private void viewAllTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
        // to view all tasklist with details
        HttpSession session = request.getSession();
        User dbUser = userService.getUserIdByMail((String) session.getAttribute("email"));

        if (dbUser.getRoleId() == 1) {
            request.setAttribute("allTaskList", taskService.viewAllTasks());
            request.getRequestDispatcher("adminview.jsp").include(request, response);
        } else {
            request.setAttribute("allTaskList", taskService.viewAllTasks());
            request.getRequestDispatcher("alltask.jsp").include(request, response);
        }
        // response.sendRedirect(request.getContextPath() + "/TaskController?action=alltasks");
    }
}