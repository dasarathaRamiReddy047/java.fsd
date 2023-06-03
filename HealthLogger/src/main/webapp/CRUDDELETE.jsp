<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%
    String id = request.getParameter("id");

    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String password = "1234567890";

    String sql = "DELETE FROM patients WHERE id = ?";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, id);
        p.executeUpdate();
       
        response.sendRedirect("ManagePatientsPage.jsp");

    } catch (Exception e) {
        e.printStackTrace();
       
    }
%>

</body>
</html>
