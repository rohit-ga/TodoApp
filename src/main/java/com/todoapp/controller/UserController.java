package com.todoapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todoapp.model.User;
import com.todoapp.service.impl.TaskServiceImpl;
import com.todoapp.service.impl.UserServiceImpl;
import com.todoapp.util.Constant;

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

        if (action.equals("register")) {
            registerUser(request, response);

        } else if (action.equals("signin")) {
            loginUser(request, response);

        } else if (action.equals("logout")) {
            response.sendRedirect("home.jsp");
        }
    }

    protected void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String sex = request.getParameter("sex");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer roleId = Integer.parseInt(request.getParameter("roleId"));

        User user = new User(fName, lName, sex, contact, email, password, roleId);
        boolean result = userService.registerUser(user);

        if (!result) {
            request.setAttribute("message", Constant.REGISTARTION_ERROR_MESSAGE);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            request.setAttribute("message", Constant.REGISTARTION_SUCCESSFUL_MESSAGE);
            request.getRequestDispatcher("home.jsp").include(request, response);
        }
    }

    protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException,
            SQLException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean result = userService.loginUser(email, password);

        /* login success event */
        if (result) {
            request.setAttribute("message", Constant.LOGIN_SUCCESSFULLY_MESSAGE);

            /* creating sesssion for storing the loggedin user email ID */
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);

            /* fetching the user by its id */
            User dbuser = userService.getUserIdByMail(email);

            // ADMIN LOGIN
            if (dbuser.getRoleId() == 1) {
                request.setAttribute("allTaskList", taskService.viewAllTasks());
                request.getRequestDispatcher("adminview.jsp").forward(request, response);
            } else {
                /* Normal User */
                request.setAttribute("allTask", taskService.viewAllTasks().size());
                request.setAttribute("myTask", taskService.getTaskByUserId(dbuser.getUserId()).size());
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
        } else {
            /* wrong inputs during login */
            request.setAttribute("message", Constant.LOGIN_ERROR_MESSAGE);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}