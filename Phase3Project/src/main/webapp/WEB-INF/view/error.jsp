<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style type="text/css">
    .con{
    text-align: center;}
    
    </style>
</head>
<body>

<div class="con">
    <h1>Error</h1>
    <p>An unexpected error has occurred.</p>
    
    <%
    String error = (String) request.getAttribute("errorMessage");
    %>
    
    <p>Error Details: <%= error %></p>
    </div>
</body>
</html>

