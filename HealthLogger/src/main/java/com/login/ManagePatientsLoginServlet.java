package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/manage") 

public class ManagePatientsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user=(String) session.getAttribute("user");
		String password =(String) session.getAttribute("password");
		
		if(user != null && password != null) {
			response.sendRedirect("ManagePatientsPage.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
		
		System.out.println(user+password);

		
	}

}
