<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        text-align: center;
    }

    .buttonLogin {
        background-color: #337ab7;
        color: #ffffff;
        padding: 10px 20px;
        border-radius: 5px;
        border: none;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .buttonLogin:hover {
        background-color: #286090;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Health Logger</h1>
    <p>Developed by DASARATHA RAMI REDDY</p>
   <a href="Login.jsp" ><button id="loginButton" class="buttonLogin">Doctor Login</button></a>
</div>



</body>
</html>
