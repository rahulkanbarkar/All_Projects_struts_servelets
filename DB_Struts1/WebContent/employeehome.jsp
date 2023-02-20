<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login succesfully</title>

</head>
<center>
<body style="background-color:#fffbf0;">
<h1 style="border:2px solid black;height:50px;width:500px; font-size:20pt;">Employee Home Page</h1><br>
<% String name=(String) session.getAttribute("username") ; %>
<h1 style="color:red">You have Successfully Logged in , Hii <mark><%= name %></mark></h1>

<h3>Please click below to logout:</h3>
<a href="./logout.do"><h3>Logout</h3></a>


</body>
</center>
</html>