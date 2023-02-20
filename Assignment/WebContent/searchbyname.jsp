<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html><%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1><bean:message key="title"/></h1>

<html:form action="empfindbyname" method="post">
<pre>
<bean:message key="name"/>          <html:text property="name"/>


<html:submit property="findbyname"> <bean:message key="findbyname"/></html:submit>


</pre>
           </html:form>

<center>
<table border="1">
<tr>ID
	<th></th>
	<th>Name</th>
	<th>DOB</th>
	<th>manager</th>
	<th>Location</th>
	<th>Email</th>
	<th>JobType</th>
<!-- 	<th>Edit</th>
	<th>Delete</th> -->
</tr>	
<c:forEach items="${list }" var="list">
<tr>
	<td><c:out value="${list.id   }" /></td>
	<td><c:out value="${list.name }" /></td>
	<td><c:out value="${list.dob  }" /></td>
	<td><c:out value="${list.manager  }" /></td> 
	<td><c:out value="${list.location }" /></td>
	<td><c:out value="${list.email    }" /></td>
	<td><c:out value="${list.jobtype  }" /></td>
	<%-- <td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
	<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td> --%>
</tr>
</c:forEach>
</table>
<h3> <a href="addemp.jsp"><--Back </a></h3>
</center>
</body>

</html>


