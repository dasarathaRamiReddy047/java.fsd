<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .headingCon {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px;
        }

          .button {
            background-color: #87CEEB;
            text-decoration:none;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

      

        .delete {
            background-color: #d9534f;
        }

        .button-container {
            margin-bottom: 10px;
            text-align: right;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .alert {
            background-color: #f8d7da;
            color: #721c24;
            padding: 8px;
            margin-bottom: 10px;
        }
        
        .delete {
            background-color: #d9534f;
            margin: 10px;
            color: #ffffff;
        }
    </style>
</head>
<body>
<div class="headingCon">
    <h1>Doctor Home Page</h1>
    <a href="index.jsp" class="button">Logout</a>
</div>
<div class="button-container">
  <a href="ManagePatientsPage.jsp" > <button class="button">Manage Patients</button></a>
   <a href="export"> <button class="button">Export</button></a>
   <a href="AddVitals.jsp"> <button class="button">Record New Vitals</button></a>
   <a href="VitalAlerts.jsp"> <button class="button">Vital Alerts</button></a>
</div>
<p class="paragraph">Vitals</p>

<table>
    <tr>
        <th>Sr.No</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Bplow</th>
        <th>BpHigh</th>
        <th>Spo2</th>
        <th>Recorded On</th>
        <th>Action</th>
    </tr>
    <% 
    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String password = "1234567890";

    String sql = "SELECT * FROM VITALDATA ORDER BY id";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int count = 1;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            int bplow = rs.getInt("bplow");
            int bphigh = rs.getInt("bphigh");
            int spo2 = rs.getInt("spo2");
            Date record = rs.getDate("recorded");

            %> 
            <tr>
                <td><%= count %></td>
                <td><%= name %></td>
                <td><%= phone %></td>
                <td><%= bplow %></td>
                <td><%= bphigh %></td>
                <td><%= spo2 %></td>
                <td><%= record %></td>
                <td>
                  <a href="DeleteVitals.jsp?id=<%=id%>"><button type="button" class="delete button">Delete</button></a>
                </td>
            </tr>
            <%
            count++;
        }

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    %>
</table>


</body>
</html>
