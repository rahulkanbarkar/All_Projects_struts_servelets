<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<title>Reg page</title>
</head>
<body style="background-color:#fffbf0;">
<center>
<pre>
<h1 style="border:2px solid black;height:50px;width:500px; font-size:20pt;">Employee Registration Form</h1>
<html:form action="empcrud">
Id:	    <html:text property="id" />

Name:       <html:text property="name" />

Email*:      <html:text property="email" /><html:errors property="email" />

Gender:                        <html:radio property="gender" value="Male" />Male
		                 <html:radio property="gender" value="FeMale" />FeMale

UserName:   <html:text  property="username" />

Password:   <html:text property="password" />
</h4>

      <html:submit property="submit">save</html:submit><br>	
      <html:submit property="submit">find</html:submit><br>
      <html:submit property="submit">findAll</html:submit>
      
      <html:submit property="submit">findAllByWebService</html:submit>
       
       <html:submit property="submit">exportxl</html:submit>
       
       <html:submit property="submit">importTextFile</html:submit>
       
      
        </html:form>
</pre>
<a href="login.jsp"> <h1>Login Page</h1></a>
<a href="fileUpload.jsp"><h1>upload</h1></a>

</center>
</body>

</html>