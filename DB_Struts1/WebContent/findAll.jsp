<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<body style="background-color:#fffbf0;">
<center>
<table border="2">
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Gender</th>

	<th>UserName</th>
	<th>Password</th>
</tr>
<c:forEach items="${reslist}" var="list">
<tr>
	<td ><html:link action="/returnupdatedelete?idSelected=${list.id}"><c:out value="${list.id}" /></html:link></td>
	<td><c:out value="${list.name }" /></td>
	<td><c:out value="${list.email }" /></td>
	<td><c:out value="${list.gender }" /></td>
	<td><c:out value="${list.username }" /></td>
	<td><c:out value="${list.password }" /></td>
</tr>
</c:forEach>
</table><br><br>
<h3> <a href="reg.jsp"><--Back </a></h3>
For Go to login page Click Here!--><a href="login.jsp"><h3>Login</h3></a>

<%-- <html:form action="/Upload" method="post" enctype="multipart/form-data">
<br />
	Choose : <html:file property="file" size="50" />
<br />
<br />
<html:submit>
	Submit
</html:submit> 

</html:form>--%>
</center>
</body>

</html>