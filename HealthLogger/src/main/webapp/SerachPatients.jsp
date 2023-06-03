<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Home Page</title>
    <style>
        .container {
            margin: 20px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .logout-button {
        
            padding: 5px 10px;
            cursor: pointer;
        }
        .buttonCon {
            margin-top: 20px;
            display: flex;
        }
        .buttons {
            margin:10px;
        }
        .search-form {
            margin-top: 20px;
        }
        .search-input {
            display: inline-block;
            width: 300px;
            padding: 8px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: none;
            transition: border-color 0.3s ease;
        }
        .search-button {
            display: inline-block;
            padding: 8px 16px;
            font-size: 16px;
            background-color: #5b9dd9;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        table {
            margin-top: 20px;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
       
        table tr:hover {
            background-color: #f5f5f5;
        }
        
        .btn {
            background-color: #87CEEB;
         
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
            margin: 10px;
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
        
        
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Doctor Home Page</h1>
            <form method="post" action="index.jsp">
                <input type="submit" class="btn" value="Logout">
            </form>
        </div>
        <div>
            <div class="buttonCon">
                <form method="get" action="VitalView.jsp" class="">
                    <input type="submit" class="btn" value="Home">
                </form>
                <form method="get" action="AddPatient.jsp">
                    <input type="submit" class="btn" value="Add Patient">
                </form>
            </div>
        </div>
        <p>Search Patients</p>
        <form method="post" action="" class="search-form">
            <input type="text" name="searchName" class="search-input" placeholder="Search Patient">
            <input type="submit" class="search-button" value="Search">
        </form>

        <% 
            String searchName = request.getParameter("searchName");

            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "1234567890";

            String tableHtml = "";
            int resultCount = 0;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();

                if (searchName != null) {
                    String sql = "SELECT * FROM patients WHERE name LIKE '%" + searchName + "%' ORDER BY id ASC";
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
                        tableHtml += "<tr>";
                        tableHtml += "<td>" + id + "</td>";
                        tableHtml += "<td>" + name + "</td>";
                        tableHtml += "<td>" + age + "</td>";
                        tableHtml += "<td>" + email + "</td>";
                        tableHtml += "<td>" + phone + "</td>";
                        tableHtml += "<td>" + diagnosis + "</td>";
                        tableHtml += "<td>" + remark + "</td>";
                        tableHtml += "<td>" + gender + "</td>";
                        tableHtml += "<td>" +
                        		  "<a href='PatientVital.jsp?id=" + id + "'><button class='btn'>Manage Vitals</button></a>" +
                            "<a href='Update.jsp?id=" + id + "'><button class='btn'>Update</button></a>" +
                            "<a href='CRUDDELETE.jsp?id=" + id + "'><button class='delete'>Delete</button></a>" +
                            "</td>";
                        tableHtml += "</tr>";

                        resultCount++;
                    }

                    rs.close();
                }

                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
        
        <h3>Patients[<%= resultCount %>]</h3>
        
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
                <th>Action</th>
             
            </tr>
            <%= tableHtml %>
        </table>
    </div>
</body>
</html>
