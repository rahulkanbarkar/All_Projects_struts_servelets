<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 
 <html>
 <head>
 <title>Login</title>
 </head>
 <body style="background-image: url('img2.jpg');background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">
 <center><br>
<h1 style="border:1.5px solid black;height:40px;width:400px; font-size:20pt;">Login Form</h1>
<html:form action="login">
<h3>
<bean:message key="username" /><html:text property="username" /><br>

<html:errors property="username" /><br><br>

Password:<html:text property="password" /><br>
<html:errors property="password" /><br>

<% String err=(String)request.getAttribute("invaliddata"); 
%>
<h3 style="color:red">
<%if(err!= null){
out.print(err);
}%>
</h3>
<html:submit>Login</html:submit><br><br>

</html:form>
<h4><span style="color:blue">If you are a New User! click here </span></h4>			<h3> <a href="reg.jsp">Register </a></h3>
</center>
 </body>
 </html>
 
