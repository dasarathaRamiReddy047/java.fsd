<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    .con {
        text-align: center;
        margin-top: 100px;
    }
    .input-field {
        margin: 10px;
    }
    .button {
        margin: 10px;
    }
</style>
</head>
<body>
    <div class="con">
        <h2>Login</h2>
        <form action="/vaccinationcenter" method="Get">
            <div class="input-field">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
            </div>
            <div class="input-field">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="button">
                <input type="submit" value="Login">
            </div>
        </form>
        <p>Don't have an account? <a href="/register">Register</a></p>
    </div>
</body>
</html>
