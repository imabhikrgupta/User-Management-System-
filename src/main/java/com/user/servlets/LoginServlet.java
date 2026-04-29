package com.user.servlets;

import java.io.IOException;

import com.user.connection.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4786491048006993201L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
				UserDAO dao=new UserDAO();
		if(dao.loginUser(email, password)) {
			HttpSession session=req.getSession();
			session.setAttribute("userEmail",email);
			resp.sendRedirect("dashbord.html");
			
		}
		else {
	     resp.getWriter().println("Invalid Email or Password");
	}
 }
}
