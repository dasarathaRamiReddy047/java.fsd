<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
        }
        
        .container {
            width: 400px;
            margin-left:80vh;
            margin-top:20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        
        form {
            text-align: left;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }
        
       .submit{
       margin:10px;
       }
       .h1{
       text-align: left;
       }
        
    </style>
    <title>Edit Citizen</title>
</head>
<body>
<h1 class="h1">Citizen Information</h1>
    <div class="container">
        <h1>Edit Citizen </h1>
        <form action="/citizens/edit/${citizen.id}" method="post">
            <input type="hidden" name="_method" value="PUT">
            
            <label for="name">Name:</label>
            <input type="text" name="name" value="${citizen.name}">
            
            <label for="city">City:</label>
            <input type="text" name="city" value="${citizen.city}">
            
            <label for="doses">Doses:</label>
            <input type="number" name="doses" value="${citizen.doses}">
            
            <label for="status">Status:</label>
            <input type="text" name="status" value="${citizen.status}">
            
            <label for="center">Center:</label>
            <input type="text" name="center" value="${citizen.center}">
            
            
            <input class="submit" type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
