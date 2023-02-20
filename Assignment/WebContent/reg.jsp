<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<title>Admin Regestration page</title>
</head>
<body style="background-color:#fffbf0;">
<center>
<pre>
<h1 style="border:2px solid black;height:50px;width:500px; font-size:20pt;">Admin Registration Form</h1>

<html:form action="adminreg" >
Userid:     <html:text property="userid" styleId="userid"/><br><br>
Name:       <html:text property="name" styleId="name"/><br><br>
Email*:     <html:text property="email" styleId="email"/><html:errors property="email" /><br><br>
Gender:               	Male   <html:radio property="gender" value="Male" />
		         FeMale <html:radio property="gender" value="FeMale" />  <br><br>
            
UserName:   <html:text property="username" styleId="username" /><br><br>
Password:   <html:text property="password" styleId="username"/><br><br>


</h4>
 <html:submit property="submit">save</html:submit><br>	
 <html:submit property="submit">exportxl</html:submit><br>	
  <html:submit property="submit">importTextFile</html:submit>
	
</html:form>
</pre>
<a href="login.jsp"> <h1>Login Page</h1></a>

</center>


</body>

</html>