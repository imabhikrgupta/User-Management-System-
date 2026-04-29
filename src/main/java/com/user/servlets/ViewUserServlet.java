package com.user.servlets;

import java.io.IOException;
import java.util.List;

import com.user.connection.User;
import com.user.connection.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewUser")
public class ViewUserServlet extends HttpServlet {

	private UserDAO userDAO = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> users=userDAO.getAllUser();
		req.setAttribute("userList", users);
		 
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewUser.jsp");
		requestDispatcher.forward(req, resp);
	}

}
