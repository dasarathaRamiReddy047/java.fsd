<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.GsonBuilder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vital Data Chart</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
     <style>
        table {
            width: 100%;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
        
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        
        .title {
            margin-left: 20px;
        }
        
        .logout-btn {
            background-color: #87CEEB;
            margin-right: 20px;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
            color: white;
        }
        
        .button {
            background-color: #87CEEB;
            margin: 10px;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        
        .delete {
            background-color: #d9534f;
            margin: 10px;
            color: #ffffff;
        }
        
        
    </style>
</head>
<body>
  <div class="header">
        <h1 class="title">Doctor Home Page</h1>
        <a href="index.jsp" class="logout-btn">Logout</a>
    </div>
    
    <div class="buttons">
        <a href="ManagePatientsPage.jsp"><button class="button">Manage Patients</button></a>
        <a href="export"><button class="button">Export</button></a>
        <a href="AddVitals.jsp"><button class="button">Record New Vital</button></a>
        <a href="VitalAlerts.jsp"><button class="button">Vital Alerts</button></a>
    </div>
    
  <div id="myChart" style="width: 100%; max-width: ; height: 500px;"></div>
  


    <table>
        <tr>
            <th>Sr.No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Low BP</th>
            <th>High BP</th>
            <th>SpO2</th>
            <th>Recorded</th>
            <th>Action</th>
        </tr>
  

  <%
  String name = request.getParameter("id");
  String url = "jdbc:mysql://localhost:3306/project";
  String user = "root";
  String password = "1234567890";
  String sql = "SELECT * FROM VitalData WHERE name LIKE '%" + name + "%'";
  try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

     
      List<List<Object>> data = new ArrayList<>();
      int count = 0;
      while (rs.next()) {
    	  int id = rs.getInt("id");
          String patientName = rs.getString("name");
          String phone = rs.getString("phone");
          String bplow = rs.getString("bplow");
          String bphigh = rs.getString("bphigh");
          String spo2 = rs.getString("spo2");
          String recorded = rs.getString("recorded");
      
          count++;

          List<Object> rowData = new ArrayList<>();
          rowData.add(new java.util.Date(java.sql.Timestamp.valueOf(recorded).getTime())); 
          rowData.add(Integer.parseInt(bplow));
          rowData.add(Integer.parseInt(bphigh));
          rowData.add(Integer.parseInt(spo2));
          data.add(rowData);
          
          %>
          <tr>
              <td><%= count %></td>
              <td><%= id %></td>
              <td><%= patientName %></td>
              <td><%= phone %></td>
              <td><%= bplow %></td>
              <td><%= bphigh %></td>
              <td><%= spo2 %></td>
              <td><%= recorded %></td>
              <td><a href="DeleteVitals.jsp?id=<%= id %>"><button class="delete button">Delete</button></a></td>
          </tr>
  <%
      }
  
      if (!data.isEmpty()) {
          Gson gson = new Gson();
          String jsonData = gson.toJson(data);
  %>
  
  </table>
  
  <script>
    google.charts.load('current', { packages: ['corechart'] });
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var jsonData = <%= jsonData %>;

      var data = new google.visualization.DataTable();
      data.addColumn('date', 'Date');
      data.addColumn('number', 'bplow');
      data.addColumn('number', 'bphigh');
      data.addColumn('number', 'spo2');

      jsonData.forEach(function (row) {
        var date = new Date(row[0]);
        var bplow = row[1];
        var bphigh = row[2];
        var spo2 = row[3];
        data.addRow([date, bplow, bphigh, spo2]);
      });

      var options = {
        title: "Patient's Vital",
        hAxis: { title: 'Recorded', format: 'MMM dd, yyyy' },
        vAxis: { title: 'Vital', minValue: 0, maxValue: 200, gridlines: { count: 20 } },
        colors: ['red', 'blue', 'green'], 
        legend: { position: 'top', textStyle: { color: 'black', fontSize: 12 } },
      };

      var chart = new google.visualization.LineChart(document.getElementById('myChart'));
      chart.draw(data, options);
    }
  </script>

  <%
      } else {
  	%>
      <tr>
          <td colspan="9">
              <h1>No Data Found</h1>
          </td>
      </tr>
<%
  }
  
  rs.close();
  stmt.close();
  conn.close();
  
} catch (Exception e) {
    e.printStackTrace();
}
%>
</table>
</body>
</html>
