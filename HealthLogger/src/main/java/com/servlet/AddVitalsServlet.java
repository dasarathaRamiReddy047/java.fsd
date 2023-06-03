package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class AddVitalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = "jdbc:mysql://localhost:3306/project";
	    String user = "root";
	    String password = "1234567890";

	    String name = request.getParameter("name");
	    int bpLow = Integer.parseInt(request.getParameter("bpLow"));
	    int bpHigh = Integer.parseInt(request.getParameter("bpHigh"));
	    int Spo = Integer.parseInt(request.getParameter("spO2"));
	    
	    PrintWriter out = response.getWriter();
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, user, password);
	        String query = "INSERT INTO vitals (name, BpLow, BpHigh, Spo2) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, name);
	        pstmt.setInt(2, bpLow);
	        pstmt.setInt(3, bpHigh);
	        pstmt.setInt(4, Spo);
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	   
	    
		
	}

