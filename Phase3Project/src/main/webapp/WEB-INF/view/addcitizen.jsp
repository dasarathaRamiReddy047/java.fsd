<%@page import="com.phase.Phase3Project.entity.Centers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Citizen</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        .heading{
        text-align: left;
        }
        
        h1 {
            color: #333;
            text-align: center;
        }
        
        .form-container {
            width: 300px;
            margin: 0 auto;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
        }
        
        input[type="text"],
        input[type="number"],select {
            padding: 5px;
            width: 100%;
            margin-bottom: 10px;
        }
        
        
        
        
    </style>
</head>
<body>
<h1 class="heading">Citizen Information</h1>
<% 
List<Centers> centers = (List<Centers>) request.getAttribute("centers");
%>

    <h1>Add new Citizen</h1>
    <div class="form-container">
        <form action="/citizens/add" method="post">
            <label for="name">Citizen Name:</label>
            <input type="text" name="name"><br>
            
            <label for="city">Citizen City:</label>
       
            
            <select name="city">
            <% for (Centers c : centers){ %>
            <option value="<%= c.getCity() %>"><%= c.getCity() %></option>
               <% } %>
            </select>
         
            <br>
            
            <label for="doses">Doses:</label>
            <input type="number" name="doses"><br>
            
            <label for="status">Status:</label>
            <input type="text" name="status"><br>
            
    
            
           <label for="center">Citizen Center:</label>
          
			<select name="center">
			    <% for(Centers c : centers) { %>
			        <option value="<%= c.getCenter() %>"><%= c.getCenter() %></option>
			    <% } %>
			</select>
			<br>
            
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
