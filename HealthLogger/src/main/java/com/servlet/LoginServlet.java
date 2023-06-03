package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(user.equals("user") && password.equals("1234")) {
			System.out.println("Successful Login");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("password", password);
		
			response.sendRedirect("ManagePatients.jsp");
		} else {
			String errorMessage = "Invalid credentials. Please try again.";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
}
