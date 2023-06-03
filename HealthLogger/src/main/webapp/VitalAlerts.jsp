<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vital Alerts</title>
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
        
        .delete {
            background-color: #d9534f;
            margin: 10px;
            color: #ffffff;
             margin-left: auto;
        margin-right: 10px;
        padding: 6px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s ease;
        margin: 10px;
        }

    

        table {
            width: 100%;
            border-collapse: collapse;
        }
        .alertHeading{
        color:red;
        background-color:#ffffff;
        
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

        .high-bp {
            color: red;
           font-weight:700;
        }

        .normal-bp {
            color: black;
        }
         .button-container {
            margin-bottom: 10px;
            text-align: right;
        }
          .button {
        background-color: #87CEEB;
        margin-left: auto;
        margin-right: 10px;
        padding: 6px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s ease;
        margin: 10px;
    }
        
    </style>
</head>
<body>
<div class="headingCon">
    <h1 class="alertHeading">Vital Alerts</h1>
    <a href="logout" class="button button-primary">Logout</a>
</div>
<div class="button-container">
   <a href="ManagePatientsPage.jsp"> <button class="button">Manage Patients</button></a>
   <a href="export"><button class="button" >Export Data</button></a>
   <a href="AddVitals.jsp"><button class="button" onclick="recordVitals()">Record New Vitals</button></a>
</div>
<p class="paragraph">Vitals</p>

<table>
    <tr>
        <th class="normal-bp">Sr.No</th>
        <th class="normal-bp">Name</th>
        <th class="normal-bp">Phone</th>
        <th class="bp-column">Bplow</th>
        <th class="bp-column">BpHigh</th>
        <th class="normal-bp">Spo2</th>
        <th class="normal-bp">Recorded On</th>
        <th class="normal-bp">Action</th>
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
                <td class="normal-bp"><%= count %></td>
                <td class="normal-bp"><%= name %></td>
                <td class="normal-bp"><%= phone %></td>
                <td class="<% if (bplow < 90) { %>high-bp<% } else { %>normal-bp<% } %>"><%= bplow %></td>
                <td class="<% if (bphigh > 120) { %>high-bp<% } else { %>normal-bp<% } %>"><%= bphigh %></td>
                <td class="normal-bp"><%= spo2 %></td>
                <td class="normal-bp"><%= record %></td>
                <td class="normal-bp">
                     <a href="DeleteVitals.jsp?id=<%=id%>"><button type="button" class="delete">Delete</button></a>
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
