package com.firetech.blackghost.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firetech.blackghost.Constants;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 7793452640852607052L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(Constants.SESSION_USER, "admin");
            resp.sendRedirect("mgmt/assignments.html");
        } else {
            resp.sendRedirect("login.html");
        }
    }

}
