package com.todoapp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.todoapp.model.UserRole;
import com.todoapp.service.impl.TaskServiceImpl;
import com.todoapp.service.impl.UserServiceImpl;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserServiceImpl userService = new UserServiceImpl();
    TaskServiceImpl taskService = new TaskServiceImpl();
    User user = new User();

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

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
        String action = request.getParameter("action");
        System.out.println("action of User controller:::" + action);
        if (action.equalsIgnoreCase("register")) {
            registerUser(request, response);
        } else if (action.equalsIgnoreCase("signin")) {
            loginUser(request, response);
        } else if (action.equals("logout")) {
            response.sendRedirect("home.jsp");
        } else if (action.equals("signin")) {
            authenticateUser(request, response);
        }
    }

    private void authenticateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user.setUserEmail(email);
        user.setUserPassword(password);
        UserRole dbRole = userService.authenticateUser(user);

        if (dbRole.getRoleId() == admin) {
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);

            RequestDispatcher view = request.getRequestDispatcher("adminview.jsp");
            view.forward(request, response);
        } else {
            loginUser(request, response);
        }
    }

    protected void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String sex = request.getParameter("sex");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String message = "";

        user.setUserFname(fname);
        user.setUserLname(lname);
        user.setUserGender(sex);
        user.setUserContact(contact);
        user.setUserEmail(email);
        user.setUserPassword(password);
        message = userService.registerUser(user);

        if (message.equalsIgnoreCase("You have already registerd with this email")) {
            request.setAttribute("message", message);
            RequestDispatcher view = request.getRequestDispatcher("register.jsp");
            view.forward(request, response);
        } else if (message.equalsIgnoreCase("You are successfully registered ")) {
            request.setAttribute("message", message);
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.include(request, response);
        }
    }

    protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException,
            SQLException, ServletException {
        
          String email = request.getParameter("email");
          /*String password = request.getParameter("password");
          user.setUserEmail(email); user.setUserPassword(password);*/
         
        String message = "";
        message = userService.loginUser(user);

        if (message.equalsIgnoreCase("You have login successfully")) {
            request.setAttribute("message", message);

            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);

            List<Task> allTaskList = taskService.viewAllTasks();
            int allTask = allTaskList.size();
            request.setAttribute("allTask", allTask);

            User dbuser = userService.getUserIdByMail(email);
            List<Task> myTaskList = taskService.getTaskByUserId(dbuser.getUserId());
            int myTask = myTaskList.size();
            request.setAttribute("myTask", myTask);

            RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
            view.forward(request, response);

            // response.sendRedirect(request.getContextPath() + "/TaskController?action=dashboard");

        } else if (message.equalsIgnoreCase("Email or Password is not correct")) {
            request.setAttribute("message", message);

            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        }
    }
}