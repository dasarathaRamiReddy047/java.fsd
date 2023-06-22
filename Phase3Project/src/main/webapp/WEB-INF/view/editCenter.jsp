<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
    .container {
            text-align: center;
          
            padding: 20px;
        }
      label {
            margin-bottom: 10px;
        }
        
        input[type="text"] {
            padding: 5px;
            margin-bottom: 10px;
        }
        
        input[type="submit"] {
            padding: 5px 10px;
        }
        
    </style>
    <title>Edit Center</title>
</head>
<body>
<h1>Center Information</h1>
    <div class="container">
        <h1>Edit  ${center.center}</h1>
        <form method="post" action="/vaccinationcenter/edit/${center.id}">
            <input type="hidden" name="_method" value="PUT">
            <input type="hidden" name="id" value="${center.id}">

            
            <label for="center">Center Name:</label>
            <input type="text" name="center" value="${center.center}">
            <br>
                        <label for="city">Center City:</label>
            <input type="text" name="city" value="${center.city}">
            <br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>


