<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 <link rel="stylesheet" href="logins.css">
 <html>
 <head>
 <title>Employee Database System</title>
 </head>
 <body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">
 <center><br>
<h1>Login Form</h1>
<html:form action="login">
<div>
<h3>

<bean:message key="userid" /><html:text property="userid" /><br>

<%-- <html:errors property="userid" /><br><br> --%>

Password:<html:text property="password" /><br>
<%-- <html:errors property="password" /><br> --%>

<% String err=(String)request.getAttribute("invaliddata"); 
%>
<h3 style="color:red">
<%if(err!= null){
out.print(err);
}%>
</h3>

<html:submit>Login</html:submit><br><br>

</html:form>

<h4><span style="color:blue">If you are a New User! click here </span></h4>		
<h3> <a href="reg.jsp">Register </a></h3>
</center>

</div>

 </body>
 </html>
 
