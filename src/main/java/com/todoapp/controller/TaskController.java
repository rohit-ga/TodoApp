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
        
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("create")) {

            createTask(request, response);
        } else if (action.equalsIgnoreCase("alltasks")) {
            
            viewAllTask(request, response);
        } else if (action.equalsIgnoreCase("mytasks")) {

            getMyTask(request, response);
        } else if (action.equalsIgnoreCase("dashboard")) {
            
            taskCount(request,response);
        }else if (action.equalsIgnoreCase("success")) {
            System.out.println("I am invoked");
            taskCount(request,response);
        }
    }

    private void taskCount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        
        List<Task> taskList = new ArrayList<Task>();
        
        TaskServiceImpl taskService = new TaskServiceImpl();
        taskList = taskService.viewAllTasks();

        int allTask = taskList.size();
        
        request.setAttribute("allTask", allTask);

        User dbuser = userServices.getUserIdByMail(email);

        taskList = taskService.getTaskByUserId(dbuser.getUid());

        int mytask = taskList.size();

        request.setAttribute("mytask", mytask);

        RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request, response);
        
    }

    private List<Task> getMyTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
        List<Task> taskList = new ArrayList<Task>();

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        User dbuser = userServices.getUserIdByMail(email);
        
        TaskServiceImpl taskService = new TaskServiceImpl();
        
        taskList = taskService.getTaskByUserId(dbuser.getUid());
        
        request.setAttribute("taskList", taskList);

        RequestDispatcher view = request.getRequestDispatcher("mytask.jsp");
        view.forward(request, response);

        return taskList; 
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
        
        List<Task> taskList = taskService.getTaskByUserId(user.getUid());
        
        //System.out.println("In createTask of task controller method::" + taskList);
        
        request.setAttribute("taskList", taskList);

        RequestDispatcher view = request.getRequestDispatcher("mytask.jsp");
        view.forward(request, response);
    }

    private List<Task> viewAllTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
        
        List<Task> taskList = new ArrayList<Task>();

        TaskServiceImpl taskService = new TaskServiceImpl();
        taskList = taskService.viewAllTasks();

        request.setAttribute("taskList", taskList);

        RequestDispatcher view = request.getRequestDispatcher("alltask.jsp");
        view.forward(request, response);

        return taskList;

    }

}
