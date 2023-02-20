<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body style="background-color:#fffbf0;">
<center>
<table border="1">
<tr>
	<th>ID</th>
	<th>File</th>

</tr>	
<c:forEach items="${relist }" var="list">
<tr>
	<td><c:out value="${list.id }" /></td>
	<td><c:out value="${list.name }" /></td>
</tr>
</c:forEach>
</table>
<h3> <a href="addemp.jsp"><--Back </a></h3>
</center>
</body>
</html>