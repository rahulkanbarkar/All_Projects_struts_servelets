<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body style="background-color:#fffbf0;">
<center>
<table  width="60%" border="" cellpadding="2">
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>DOB</th>
	<th>manager</th>
	<th>Location</th>
	<th>Email</th>
	<th>JobType</th>
</tr>	
<c:forEach items="${reslist }" var="list">
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
<a href="addemp.jsp">Add Employee</a><br><br>
</center>
</body>
</html>