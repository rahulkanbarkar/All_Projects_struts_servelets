<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<body style="background-color:#fffbf0;">
<html:form action="/empcrud">
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
<c:forEach items="${updatelist}" var="list">
<tr>
	<td><html:link action="/returnupdatedelete">Edit <c:out value="${list.id }" /></html:link></td>
	<%-- <td><c:out value="${list.name }" /></td>
	<td><c:out value="${list.email }" /></td>
	<td><c:out value="${list.gender }" /></td>
	<td><c:out value="${list.username }" /></td>
	<td><c:out value="${list.password }" /></td> --%>
	<td ><input type="text" name="name"  value='<c:out value="${list.name }"/>' /></td>
	<td><input type="text" name="email"  value='<c:out value="${list.email }"/>' /></td>
	<td><input type="text" name="gender"  value='<c:out value="${list.gender}"/>' /></td>
	<td><input type="text" name="username" value='<c:out value="${list.username }"/>' /></td>
	<td><input type="text" name="password" value='<c:out value="${list.password }"/>' /></td>
	
	<td><input name="id" type="hidden" value='<c:out value="${list.id }"/>' /></td>
	<td><input name="name" type="hidden" value='<c:out value="${list.name }"/>' /></td>
	<td><input name="email" type="hidden" value='<c:out value="${list.email }"/>' /></td>
	<td><input name="gender" type="hidden" value='<c:out value="${list.gender}"/>' /></td>
	<td><input name="username" type="hidden" value='<c:out value="${list.username }"/>' /></td>
	<td><input name="password" type="hidden" value='<c:out value="${list.password }"/>' /></td>
</tr>
</c:forEach>
</table><br><br>
      

<center>
 <html:submit property="submit">update</html:submit><br><br>
        <html:submit property="submit">delete</html:submit></center><br>
  
  <html:submit property="submit">findAll</html:submit>
<a href="login.jsp"><h3>Login</h3></a>
</html:form>
</body>

       
</html>