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

import com.todoapp.bean.Task;
import com.todoapp.bean.User;
import com.todoapp.service.impl.TaskServiceImpl;
import com.todoapp.service.impl.UserServicesImpl;

@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * public TaskController() { super();
     * 
     * }
     */
    User user = new User();
    UserServicesImpl userServices = new UserServicesImpl();

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
        // System.out.println("In do process::");
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("create")) {

            createTask(request, response);
        } else if (action.equalsIgnoreCase("alltasks")) {
            // System.out.println("in all tasks action::");
            viewAllTask(request, response);
        } /*else if (action.equalsIgnoreCase("dashboard")) {

            allTaskSize(request, response);
        } else if (action.equalsIgnoreCase("dashboard")) {

            myTaskSize(request, response);
        }*/
    }

    private void createTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        String taskname = request.getParameter("taskname");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        user = userServices.getUserIdByMail(email);

        Task task = new Task();

        task.setTaskName(taskname);
        task.setTaskCreationDate(new Date());

        TaskServiceImpl taskService = new TaskServiceImpl();
        taskService.createTask(task, user.getUid());

        RequestDispatcher view = request.getRequestDispatcher("createtask.jsp");
        view.forward(request, response);
    }

    private List<Task> viewAllTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
        // System.out.println("In viewAllTask method of controller");
        List<Task> taskList = new ArrayList<Task>();

        TaskServiceImpl taskService = new TaskServiceImpl();
        taskList = taskService.viewAllTasks();

        request.setAttribute("taskList", taskList);

        RequestDispatcher view = request.getRequestDispatcher("alltask.jsp");
        view.forward(request, response);

        return taskList;

    }

    /*private int allTaskSize(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {

        List<Task> taskList = new ArrayList<Task>();

        TaskServiceImpl taskService = new TaskServiceImpl();
        taskList = taskService.viewAllTasks();

        int listCount = taskList.size();

        request.setAttribute("listCount", listCount);

        RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request, response);

        return listCount;
    }*/

    /*private int myTaskSize(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {

        List<Task> taskList = new ArrayList<Task>();

        TaskServiceImpl taskService = new TaskServiceImpl();
        taskList = taskService.viewAllTasks();

        int listCount = taskList.size();
          System.out.println(listCount);
        request.setAttribute("listCount", listCount);

        RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request, response);

        return listCount;
    }*/
}
