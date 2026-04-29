package com.user.servlets;

import java.io.IOException;

import com.user.connection.User;
import com.user.connection.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	
	private UserDAO dao = new UserDAO();

	private static final long serialVersionUID = 6302603869239651433L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    int id = Integer.parseInt(req.getParameter("id"));
	    User user = dao.getUserById(id);
	    req.setAttribute("user", user);
	    req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = new User(id, name, email, password);
		
		if (dao.updateUser(user)) {
			resp.sendRedirect("viewUser");
			;
		} else {
			resp.getWriter().println("Update failed");
		}

	}
}
