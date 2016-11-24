package com.todoapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

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

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
        String action = request.getParameter("action");
     
         if(action.equalsIgnoreCase("create")){
      
             createTask(request,response);
         } else {
             
         }
     }

    private void createTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String taskname = request.getParameter("taskname");
        
        HttpSession session = request.getSession();  
        String email = (String)session.getAttribute("email");
        
        user = userServices.getUserIdByMail(email);
        
        Task task = new Task();
        
        task.setTaskName(taskname);
        task.setTaskCreationDate(new Date());
        
        TaskServiceImpl taskService = new TaskServiceImpl();
        taskService.createTask(task,user.getUid());
        
        RequestDispatcher view = request.getRequestDispatcher("createtask.jsp");
        view.forward(request, response);
    }

}
