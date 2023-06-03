<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vitals Form</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        
        .container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
            font-size: 24px;
            color: #337ab7;
            margin-bottom: 20px;
        }
        
        p {
            text-align: center;
            font-size: 14px;
            margin-bottom: 20px;
        }
        
        form {
            margin-top: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
            font-size: 16px;
            font-weight: bold;
        }
        
        select,
        input[type="number"],
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
        }
        
        input[type="submit"] {
            margin-top: 20px;
           background-color: #1FAE51;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        
    
        .back-btn {
            margin-top: 10px;
            background: none;
            border: none;
            cursor: pointer;
            color: #337ab7;
            font-size: 20px;
        }
        
      
    </style>
</head>
<body>
    <div class="container">
        <h1>Health Logger</h1>
        <p>Add Patient's Vital Information</p>
        <form action="" method="post">
            <label for="name">Name:</label>
            <select name="name" id="name" required>
                <%  
                    String url = "jdbc:mysql://localhost:3306/project";
                    String user = "root";
                    String password = "1234567890";

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stmt = con.createStatement();
                        String sql = "SELECT name FROM patients";
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String name = rs.getString("name");
                %>
                            <option value="<%= name %>"><%= name %></option>
                <%          
                        }
                        rs.close();
                        stmt.close();
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </select><br><br>

            <label for="bpLow">BpLow:</label>
            <input type="number" id="bpLow" name="bpLow" required><br><br>
            
            <label for="bpHigh">BpHigh:</label>
            <input type="number" id="bpHigh" name="bpHigh" required><br><br>

            <label for="spO2">SpO2:</label>
            <input type="number" id="spO2" name="spO2" required><br><br>

           <input type="submit" class="submit" value="Submit">
        <a href="VitalView.jsp" class="back-btn">&#8592; Back</a> 
        </form>
        
        <%  
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String name = request.getParameter("name");
            int bpLow = 0;
            int bpHigh = 0;
            int spo2 = 0;

            try {
                bpLow = Integer.parseInt(request.getParameter("bpLow"));
                bpHigh = Integer.parseInt(request.getParameter("bpHigh"));
                spo2 = Integer.parseInt(request.getParameter("spO2"));
            } catch (NumberFormatException e) {
                out.println("<p>Please enter valid integer values for BpLow, BpHigh, and SpO2.</p>");
            }

            if (bpLow != 0 && bpHigh != 0 && spo2 != 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    String query = "INSERT INTO vitals (name, BpLow, BpHigh, Spo2) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, name);
                    pstmt.setInt(2, bpLow);
                    pstmt.setInt(3, bpHigh);
                    pstmt.setInt(4, spo2);
                    pstmt.executeUpdate();
                    pstmt.close();
                    con.close();

                    out.println("<p>Data inserted successfully.</p>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        %>
     
    </div>
</body>
</html>
