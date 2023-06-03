package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/export")
public class ExportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=health_logs.csv");

        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "1234567890";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM VitalData";
            ResultSet rs = st.executeQuery(sql);

            PrintWriter writer = response.getWriter();

            if (rs.next()) {
                // Write the CSV header
                writer.println("Vitals Data");
                writer.println("id,name,phone,bplow,bphigh,spo2,recorded");

                do {
                    // Get the data from the ResultSet
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String bplow = rs.getString("bplow");
                    String bphigh = rs.getString("bphigh");
                    String spo2 = rs.getString("spo2");
                    String recorded = rs.getString("recorded");

                    // Write the data to the CSV file
                    writer.println(id + "," + name + "," + phone + "," + bplow + "," + bphigh + "," + spo2 + ","+ recorded);
                } while (rs.next());

                System.out.println("CSV file has been exported successfully.");
            } else {
                writer.println("No health logs found for the patient.");
            }

            con.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("VitalView.jsp");
    }
}
