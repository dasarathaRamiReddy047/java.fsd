<%@page import="com.aadhar.Aadhar.entity.UpdateUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<%
UpdateUser updateUser = (UpdateUser) request.getAttribute("userUpdate");
%>

<form class="form" action="updateUserDetails/{<%= updateUser.id %>}" method="get">
  <div class="form-group">
    <label for="aadharNo">Aadhar Number</label>
    <input class="form-control" type="text" id="aadharNo" name="aadharNo" placeholder="Aadhar Number" required value="<%= updateUser.getAadharNo() %>">
  </div>
  <div class="form-group">
    <label for="name">Name</label>
    <input class="form-control" type="text" id="name" name="name" placeholder="Name" required value="<%= updateUser.getName() %>">
  </div>
  <div class="form-group">
    <label for="dateOfBirth">Date of Birth</label>
    <input class="form-control" type="date" id="dateOfBirth" name="dateOfBirth" required value="<%= updateUser.getDateOfBirth() %>">
  </div>
  <div class="form-group">
    <label for="address">Address</label>
    <input class="form-control" type="text" id="address" name="address" placeholder="Address" required value="<%= updateUser.getAddress() %>">
  </div>
  <div class="form-group">
    <label for="phone">Phone Number</label>
    <input class="form-control" type="text" id="phone" name="phone" placeholder="Phone Number" required value="<%= updateUser.getPhone() %>">
  </div>
  <div class="form-group">
    <label for="status">Status</label>
    <input class="form-control" type="text" id="status" name="status" placeholder="Status" required value="<%= updateUser.getStatus() %>">
  </div>
  <button type="submit" class="btn btn-primary">Accept</button>
</form>





</body>
</html>