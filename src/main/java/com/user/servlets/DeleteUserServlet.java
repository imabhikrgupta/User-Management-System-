package com.user.servlets;

import java.io.IOException;

import com.user.connection.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = -9197491831202082160L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));

        UserDAO dao = new UserDAO();

        if (dao.deleteUser(id)) {
            resp.sendRedirect("viewUser");
        } else {
            resp.getWriter().println("Deletion failed");
        }
    }
}
