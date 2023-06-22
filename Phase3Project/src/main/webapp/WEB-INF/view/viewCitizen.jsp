<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Citizen Details</title>
    <style>
        table{
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
            display: flex;
           justify-content: center;
         
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

      P{
      font-weight: bold;
      text-align: center;
      font-size: 20px;
      }
    </style>
</head>
<body>
    <h1>Citizen Information</h1>
      <p>Name:  ${person.name}</p>
    <table>
  
        <tr>
            <th>ID:</th>
            <td>${person.id}</td>
        </tr>
    
        <tr>
            <th>City:</th>
            <td>${person.city}</td>
        </tr>
        <tr>
            <th>Doses:</th>
            <td>${person.doses}</td>
        </tr>
        <tr>
            <th>Status:</th>
            <td>${person.status}</td>
        </tr>
        <tr>
            <th>Center:</th>
            <td>${person.center}</td>
        </tr>
       
    </table>
   
</body>
</html>

