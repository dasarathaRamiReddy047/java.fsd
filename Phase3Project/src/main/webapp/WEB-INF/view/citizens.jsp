<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.phase.Phase3Project.entity.Citizens" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Citizens</title>
    <style>
        .custom-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            font-family: Arial, sans-serif;
        }

        .custom-table th,
        .custom-table td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }

        .custom-table th {
            background-color: #f2f2f2;
        }

        .custom-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .custom-table tr:hover {
            background-color: #eaeaea;
        }

        .custom-table .button {
            display: inline-block;
            padding: 6px 12px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 4px;
        }
           
           a,button{
           margin-top:10px;
           margin-left:2px;
           }

  .con {
        display: flex;
        justify-content: flex-end;
    }   
    
    p {
            font-size: 18px;
            font-weight: bold;
        }

        .logout-link {
            display: block;
            margin-top: 20px;
        }

        .add-link {
            display: block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
  
  <p class="con">Welcome Admin</p>


  <div class="con">
        <a href="/citizens" class="button">  <button type="submit">Citizens</button></a>
        <a href="/vaccinationcenter" class="button">  <button type="submit">Vaccination Centers</button></a>
        <a href="/logout" class="button">  <button type="submit">Logout</button></a>
         <a href="/citizens/add" ><button>Add New Citizen</button></a>
    </div>
     <h1>Citizens Vaccination Center</h1>
<% int count = 0; %>    
    <table class="custom-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>City</th>
                <th>Doses</th>
                <th>Status</th>
                <th>Center</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% List<Citizens> citizensList = (List<Citizens>) request.getAttribute("citizens"); %>
            <% for (Citizens citizen : citizensList) { %>
           
                <tr>
                    <td><%= citizen.getId() %></td>
                    <td><%= citizen.getName() %></td>
                    <td><%= citizen.getCity() %></td>
                    <td><%= citizen.getDoses() %></td>
                    <td><%= citizen.getStatus() %></td>
                    <td><%= citizen.getCenter() %></td>
                    <td>
                        <a href="/citizens/view/<%= citizen.getId() %>" >  <button type="submit">View</button></a>
                        <a href="/citizens/edit/<%= citizen.getId() %>" >  <button type="submit">Edit</button></a>
                    <form action="/citizens/delete/<%= citizen.getId() %>" method="POST" style="display: inline; border:none">
        <input type="hidden" name="_method" value="DELETE">
        <button type="submit" >Delete</button>
    </form>
                    </td>
                </tr>
        <% count += 1; %>
            <% } %>
          
        </tbody>
         
    </table>
            <p>Total <%= count %> Citizens Found</p> 
</body>
</html>
