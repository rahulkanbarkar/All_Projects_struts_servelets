<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<title>
Log out success
</title>
</head>
<center>
<body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;"><br><br>
<% String name=(String) session.getAttribute("username") ; %>
<h3>Hii, </h3>
<h1>You have Successfully Logged Out </h1><br><br>

For Login Again Click Here!--><a href="login.jsp"><h3>Login</h3></a>
</center>
</body>
</html>
