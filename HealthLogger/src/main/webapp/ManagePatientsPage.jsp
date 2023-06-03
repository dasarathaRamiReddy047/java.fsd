<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patients</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 100%;
            margin: 0 auto;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .header h1 {
            margin: 0;
        }

        .header .actions {
            display: flex;
            gap: 10px;
        }

        .table-wrapper {
            overflow-x: auto;
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

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .action-buttons button {
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .headingCon {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .action-buttons button.delete {
            background-color: #d9534f;
            margin: 10px;
            color: #ffffff;
        }

        .action-buttons button:hover {
            opacity: 0.8;
        }

        .buttons {
            margin: 10px;
        }

        .btn {
            background-color: #87CEEB;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="headingCon">
                <h1>Doctor Home Page</h1>
                <a href="index.jsp"><button class="btn">Logout</button></a>
            </div>

            <div class="actions">
                <a href="SerachPatients.jsp"><button id="searchButton" class="btn">Search Patient</button></a>
                <a href="AddPatient.jsp"><button id="addButton" class="btn">Add Patient</button></a>
                <a href="VitalView.jsp"><button id="manageVitals" class="btn">Manage Vitals</button></a>
            </div>
        </div>

        <div class="table-wrapper">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Diagnosis</th>
                    <th>Remark</th>
                    <th>Gender</th>
                    <th>Actions</th>
                </tr>

                <%  
                String url = "jdbc:mysql://localhost:3306/project";
                String user = "root";
                String password = "1234567890";

                String sql = "SELECT * FROM patients";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement st = con.createStatement();

                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int age = rs.getInt("age");
                        String email = rs.getString("email");
                        String phone = rs.getString("phone");
                        String diagnosis = rs.getString("diagnosis");
                        String remark = rs.getString("remark");
                        String gender = rs.getString("gender"); 
                %>

                <tr>
                    <td><%= id %></td>
                    <td><%= name %></td>
                    <td><%= age %></td>
                    <td><%= email %></td>
                    <td><%= phone %></td>
                    <td><%= diagnosis %></td>
                    <td><%= remark %></td>
                    <td><%= gender %></td>
                    <td class="action-buttons">
                        <a href="Graph.jsp?id=<%=name%>"><button type="button" class="btn">Manage Vitals</button></a>
                        <a href="Update.jsp?id=<%=id%>"><button type="button" class="btn">Update</button></a>
                        <a href="CRUDDELETE.jsp?id=<%=id%>"><button type="button" class="delete">Delete</button></a>
                    </td>
                </tr>

                <%  
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>
            </table>
        </div>
    </div>
</body>
</html>
