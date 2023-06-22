<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.phase.Phase3Project.entity.Centers"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Centers</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
      
       
           a,button{
           margin-top:10px;
           margin-left:2px;
           }
        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
  .con {
        display: flex;
        justify-content: flex-end;
    }  
        
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        tr:hover {
            background-color: #f5f5f5;
        }
        
        .button.delete {
            border: none;
        }
    </style>
</head>
<body>
    <p class="con">Welcome, Admin</p>
    <div class="con">
        <a href="/citizens" class="button">  <button type="submit">Citizens</button></a>
        <a href="/vaccinationcenter" class="button">  <button type="submit">Vaccination Centers</button></a>
        <a href="/logout" class="button">  <button type="submit">Logout</button></a>
                <a href="/vaccinationcenter/add" class="button">  <button type="submit">Add New Center</button></a>
        
    </div>
    <h2>Centers</h2>
   
   <% int count = 0; %>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>City</th>
                <th>Center</th>
                <th>Actions</th>
                <!-- Add more columns as per your Centers entity -->
            </tr>
        </thead>
        <tbody>
            <% List<Centers> centersList = (List<Centers>) request.getAttribute("centers"); %>
            <% for (Centers center : centersList) { %>
                <tr>
                    <td><%= center.getId() %></td>
                    <td><%= center.getCity() %></td>
                    <td><%= center.getCenter() %></td>
                    <td>
                        <a href="/vaccinationcenter/citizens/center/<%= center.getId() %>">  <button type="submit">View</button></a>
                        <a href="/vaccinationcenter/edit/<%= center.getId() %>">  <button type="submit">Edit</button></a>
                        <form action="/vaccinationcenter/delete/<%= center.getId() %>" method="POST" style="display: inline;">
                            <input type="hidden" name="_method" value="DELETE">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                    <!-- Display more columns and corresponding action buttons as per your Centers entity -->
                </tr>
                <% count+=1; %>
            <% } %>
        </tbody>
    </table>
    <p>Total <%= count %> vaccinationcenters Found </p> 
</body>
</html>
