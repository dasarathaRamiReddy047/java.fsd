package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteVitals extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String url = "jdbc:mysql://localhost:3306/project";
    private String user = "root";
    private String password = "1234567890";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession();
        String idParam = (String) session.getAttribute("deleteId");
        System.out.println(idParam);

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            deleteVitalsRow(id);
        }

        session.removeAttribute("deleteId"); // Remove the stored ID from the session

        response.sendRedirect("VitalView.jsp");
    }

    private void deleteVitalsRow(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM vitals WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
