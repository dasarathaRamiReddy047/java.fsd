<%@page import="com.aadhar.Aadhar.entity.UpdateUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>User Update List</title>
</head>
<body>
<%
List<UpdateUser> update = (List<UpdateUser>) request.getAttribute("update");
%>

<table class="table">
  <thead>
    <tr>
      <th>id</th>
      <th>aadharNo</th>
      <th>name</th>
      <th>dateOfBirth</th>
      <th>address</th>
      <th>Phone</th>
      <th>status</th>
      <th>update</th>
    </tr>
  </thead>
  <tbody>
    <% for (UpdateUser user : update) { %>
    <tr>
      <td><%= user.getId() %></td>
      <td><%= user.getAadharNo() %></td>
      <td><%= user.getName() %></td>
      <td><%= user.getDateOfBirth() %></td>
      <td><%= user.getAddress() %></td>
      <td><%= user.getPhone() %></td>
      <td><%= user.getStatus() %></td>
     <td>
  <a href="getUpdate/<%= user.getId() %>" class="btn btn-primary">Accept</a>
</td>

    </tr>
    <% } %>
  </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>