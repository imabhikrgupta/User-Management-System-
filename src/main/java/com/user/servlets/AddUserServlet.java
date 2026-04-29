package com.user.servlets;

import java.io.IOException;

import com.user.connection.User;
import com.user.connection.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
		resp.setContentType("text/html");
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User(id,name,email,password);
		
		UserDAO dao=new UserDAO();
		
//		IO.println(id+ name+email+password);
		if(dao.registerUser(user)) {
			resp.sendRedirect("viewUser.html");	}
		else {
			resp.getWriter().println("User add Failed");
		}
	}
}
	
	

