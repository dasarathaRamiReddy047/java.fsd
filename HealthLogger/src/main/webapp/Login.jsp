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
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        .container {
            text-align: center;
            background-color: #fff;
            padding: 40px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        .container h1 {
            color: #337ab7;
            margin-top: 0;
        }

        .container p {
            margin-bottom: 20px;
            color: #666;
            font-size:10px;
            font-weight:700;
        }

        .formGroup {
            margin-bottom: 20px;
            text-align: left;
        }

        .formGroup label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .formGroup input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }

        .buttonLogin {
            background-color: #337ab7;
            color: #fff;
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

        .error {
            color: #ff0000;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Health Logger</h1>
        <p>Developed by DASARATHA RAMI REDDY</p>

        <form action="login" method="post">
            <div class="formGroup">
                <label for="name">Username:</label>
                <input type="text" id="name" name="name" required>
            </div>
            
            <div class="formGroup">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"  required>
            </div>
            
            <input type="submit" class="buttonLogin" value="Log In">
        </form>
        
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="error">
                <%= request.getAttribute("errorMessage") %>
            </div>
        <% } %>
    </div>
</body>
</html>
 