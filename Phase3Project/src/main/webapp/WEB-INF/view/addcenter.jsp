<%@page import="com.phase.Phase3Project.entity.Centers"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Center</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        h1 {
            color: #333;
            text-align: center;
        }
        
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        form {
            margin-top: 20px;
            border: 1px solid #ccc;
            padding: 20px;
            width: 300px;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
        }
        
        input[type="text"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }
        
        .btn {
            display: flex;
            justify-content: center;
            align-items: center;
             text-decoration: none;
        }
    </style>
</head>
<body>
   <div class="container">
    <h1>Add Center</h1>
    <form action="/vaccinationcenter/add" method="post">
        <div>
            <label for="centerName">Center Name:</label>
            <input type="text" id="centerName" name="centerName" required>
        </div>
        <div>
            <label for="city">Center City:</label>
            <input type="text" id="city" name="city" required>
        </div>
        <div>
            <button>Submit</button>
        </div>
        <div>
            <a href="/vaccinationcenter" class="btn">Back</a>
        </div>
    </form>
    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null) { %>
        <p class="success-message"><%= message %></p>
    <% } %>
</div>

</body>
</html>
