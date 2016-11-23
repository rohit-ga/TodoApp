package com.todoapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todoapp.bean.User;
import com.todoapp.service.impl.UserServicesImpl;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * public UserController() { super();
     * 
     * }
     */
    User user = new User();
    UserServicesImpl userService = new UserServicesImpl();

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

        if (action.equalsIgnoreCase("register")) {

            registerUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String sex = request.getParameter("sex");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String message = "";

        PrintWriter out = response.getWriter();

        user.setUserfname(fname);
        user.setUserlname(lname);
        user.setUsergender(sex);
        user.setUsercontact(contact);
        user.setUseremail(email);
        user.setUserpassword(password);

        UserServicesImpl userService = new UserServicesImpl();
        message = userService.registerUser(user);

        if (message.equalsIgnoreCase("You have already registerd with this email")) {
            out.print(message);

            request.setAttribute("message", message);
            
            RequestDispatcher view = request.getRequestDispatcher("register.jsp");
            view.forward(request, response);

        } else if(message.equalsIgnoreCase("You have registered successfully")){
            out.println(message);
            
            request.setAttribute("message", message);

            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.include(request, response);
        }
        
        

    }

}
