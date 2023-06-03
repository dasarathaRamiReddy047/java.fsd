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

@WebServlet("/search")
public class SearchPatientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String searchName = request.getParameter("searchName");

        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "1234567890";
        PrintWriter out = response.getWriter();
        System.out.println(searchName);

        String sql = "SELECT * FROM patients WHERE name LIKE '%" + searchName + "%' order by id asc";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Results</title>");
            out.println("<style>");
            out.println("table {");
            out.println("border-collapse: collapse;");
            out.println("width: 100%;");
            out.println("}");
            out.println("th, td {");
            out.println("text-align: left;");
            out.println("padding: 8px;");
            out.println("}");
            out.println("th {");
            out.println("background-color: #f2f2f2;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Search Results</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Age</th>");
            out.println("<th>Email</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Diagnosis</th>");
            out.println("<th>Remark</th>");
            out.println("<th>Gender</th>");
            out.println("</tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String diagnosis = rs.getString("diagnosis");
                String remark = rs.getString("remark");
                String gender = rs.getString("gender");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + age + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + phone + "</td>");
                out.println("<td>" + diagnosis + "</td>");
                out.println("<td>" + remark + "</td>");
                out.println("<td>" + gender + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<br>");
            out.println("<a href=\"SerachPatients.jsp\">Back</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
