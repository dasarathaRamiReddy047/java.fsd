<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Home Page</title>
    
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
        
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        
        .title {
            margin-left: 20px;
        }
        
        .logout-btn {
            background-color: #87CEEB;
            margin-right: 20px;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
            color: white;
        }
        
        .button {
            background-color: #87CEEB;
            margin: 10px;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        
        .delete {
            background-color: #d9534f;
            margin: 10px;
            color: #ffffff;
        }
        
        
    </style>
</head>
<body>
    <div class="header">
        <h1 class="title">Doctor Home Page</h1>
        <a href="index.jsp" class="logout-btn">Logout</a>
    </div>

    <div class="buttons">
        <a href="ManagePatientsPage.jsp"><button class="button">Manage Patients</button></a>
        <a href="export"><button class="button">Export</button></a>
        <a href="AddVitals.jsp"><button class="button">Record New Vital</button></a>
        <a href="VitalAlerts.jsp"><button class="button">Vital Alerts</button></a>
    </div>

    <table>
        <tr>
            <th>Sr.No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Low BP</th>
            <th>High BP</th>
            <th>SpO2</th>
            <th>Recorded</th>
            <th>Action</th>
        </tr>

        <%  
        String name = request.getParameter("id");
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "1234567890";
        
        String sql = "SELECT * FROM VitalData WHERE name LIKE '%" + name + "%'";
        
        int count = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs != null && rs.next()) {
                do {
                    int id = rs.getInt("id");
                    String patientName = rs.getString("name");
                    String phone = rs.getString("phone");
                    String bpLow = rs.getString("bplow");
                    String bpHigh = rs.getString("bphigh");
                    String spo2 = rs.getString("spo2");
                    String recorded = rs.getString("recorded");
                
                    count++;
        %>
                <tr>
                    <td><%= count %></td>
                    <td><%= id %></td>
                    <td><%= patientName %></td>
                    <td><%= phone %></td>
                    <td><%= bpLow %></td>
                    <td><%= bpHigh %></td>
                    <td><%= spo2 %></td>
                    <td><%= recorded %></td>
                    <td><a href="DeleteVitals.jsp?id=<%= id %>"><button class="delete button">Delete</button></a></td>
                </tr>
        <%  
                } while (rs.next());
            } else {
            	%>
                <tr>
                    <td colspan="9">
                        <h1>No Data Found</h1>
                    </td>
                </tr>
        <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </table>
</body>
</html>
