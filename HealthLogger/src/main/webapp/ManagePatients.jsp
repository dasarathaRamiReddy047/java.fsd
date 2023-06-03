<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Health Dashboard</title>
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

        .Managebutton {
            background-color: #337ab7;
            color: #ffffff;
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .professional-button:hover {
            background-color: #286090;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Health Logger</h1>
        <p>Developed by DASARATHA RAMI REDDY</p>
        <form action="managePatients" method="post">
          <a href="manage"><button type="submit" class="Managebutton">Manage Patients</button></a>  
        </form>
        <br>
        <form action="manageVitals" method="post">
          <a href="manage"><button type="submit" class="Managebutton">Manage Vitals</button></a>  
        </form>
    </div>
</body>
</html>
