<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">
<center>

<h1>Employee Database System</h1>
</center>
<% String name= (String) session.getAttribute("userid"); %>
<h2>Hi <span><%= name %></span></h2>
<a href="addemp.jsp">Add Employee</a><br><br>
<a href="lindex1.jsp">Modify Employee</a><br><br>
<a href="index2.jsp">Delete Employee</a><br><br> 
<a href="./listemp.do">List Employees</a><br><br>
<a href="search.jsp">Find Employee</a><br><br> 
<a href="searchbyname.jsp">Find Employee By Name</a><br><br>
<a href="upload-file.jsp">Report Options</a><br><br>
<a href="showpicdetails.jsp">Report Details</a><br><br>
<a href="./logout.do">Logout</a><br><br>


</body>
</html>