<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<title>Add Employee</title>
<style>

div {
  text-align: justify; /* For Edge */
 
}
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 8px 15px;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
}
</style>

</style>
</head>
<body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">
  
  <%@page import="dao.EmployeeDao,beans.Employee"%>


  
  
<center>
<pre>
<h1 style="border:2px solid black;height:50px;width:500px; font-size:20pt;">Employee Registration Form</h1>
<div>
<html:form action="addemp" method="post">
id:	    <html:text property="id" /> <br>
Name:       <html:text property="name"/> <br>
     <br>
dob:        <input type="date" id="dob" name="dob"><br>
Location:   <html:text property="location" /><br>

Email:      <html:text property="email"/>	     
JobType:            <html:radio property="jobtype" value="contract" />Contract
		    <html:radio property="jobtype" value="permenant" />Permenant            

      <html:submit property="submit">Save</html:submit> 
      
        <a target="_blank" href="home.jsp"><h3>home page</h3></a> 

      </div>
</html:form>
</pre>
</center>

</body>
</html>