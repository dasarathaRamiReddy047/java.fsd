<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.phase.Phase3Project.entity.Citizens"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
            text-align: left;
        }
                a,button{
           margin-top:10px;
           margin-left:2px;
           }

  .con {
        display: flex;
        justify-content: flex-end;
    }   

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
    <title>Center Details</title>
</head>
<body>
 <p class="con">Welcome, Admin</p>
    <div class="con">
          <a href="/citizens" class="button">  <button type="submit">Citizens</button></a>
        <a href="/vaccinationcenter" class="button">  <button type="submit">Vaccination Centers</button></a>
        <a href="/logout" class="button">  <button type="submit">Logout</button></a>
    </div>
    <h1>Center Information</h1>
    <table>
    
    
        <tr>
            <th>ID</th>
            <th>CenterName</th>
            <th>City</th>
        </tr>
        <tr>
            <td>${center.id}</td>
            <td>${center.center}</td>
            <td>${center.city}</td>
        </tr>
    </table>
    <h1>All Citizens of the Centers</h1>
    <table>
  
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>action</th>
           
        </tr>
        <%
            List<Citizens> citizenList = (List<Citizens>) request.getAttribute("citizen");
            for (Citizens citizen : citizenList) {
        %>
        <tr>
            <td><%= citizen.getId() %></td>
            <td><%= citizen.getName() %></td>
          
            <td><a href="/citizens/view/<%= citizen.getId() %>"> view </a></td>            

        </tr>
        <% } %>
    </table>
</body>
</html>

