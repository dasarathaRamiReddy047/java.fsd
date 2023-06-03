<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        h1 {
            text-align: center;
            margin-top: 0;
        }
        p{
        
         text-align: center;
            margin-top: 0;
            color:gray;
            font-size:12px;
            font-weight:700;
        }

        form {
            margin-top: 20px;
        }

        .form-group {
            margin-bottom: 20px;
            border-bottom: 1px solid #ddd; 
            padding-bottom: 10px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="number"],
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-group label.radio-label {
            margin-right: 10px;
        }

        .btn-container {
            text-align: center;
            margin-top: 20px;
        }

        .button {
            background-color: #87CEEB;
            text-decoration:none;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            color:black;
        }
        .submit{
        background-color:#1FAE51;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Health Logger</h1>
        <p>Add/Update Patient Information</p>
        <form method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" required>
            </div>
          
            <div class="form-group">
                <label for="diagnosis">Diagnosis:</label>
                <textarea id="diagnosis" name="diagnosis" required></textarea>
            </div>
            <div class="form-group">
                <label for="remark">Remark:</label>
                <textarea id="remark" name="remark"></textarea>
            </div>
              <div class="form-group">
                <label>Gender:</label>
                <label class="radio-label"><input type="radio" name="gender" value="male" required> Male</label>
                <label class="radio-label"><input type="radio" name="gender" value="female" required> Female</label>
                <label class="radio-label"><input type="radio" name="gender" value="other" required> Other</label>
            </div>
            
            <div class="btn-container">
                <button type="submit" class="button submit">Submit</button>
                <a href="ManagePatientsPage.jsp" class="button">Back</a>
            </div>
        </form>
    </div>
    <% if (request.getMethod().equals("POST")) {
         
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String diagnosis = request.getParameter("diagnosis");
            String remark = request.getParameter("remark");

            
            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "1234567890";

           
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, username, password);
                String query = "INSERT INTO patients (name, email, phone, age, gender, diagnosis, remark) VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone);
                pstmt.setInt(4, age);
                pstmt.setString(5, gender);
                pstmt.setString(6, diagnosis);
                pstmt.setString(7, remark);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    %>
    <p>Submission Successful</p>
     <% } %>
</body>
</html>
