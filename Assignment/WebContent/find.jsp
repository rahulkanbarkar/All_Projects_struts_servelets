<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<pre>

<%-- <%
List l=(List)request.getAttribute("list");

%> --%>

<table border="1">
<tr><th>ID  <th>NAME</th>   <th>  DOB </th>  <th> MANAGER </th>  <th>LOCATION</th>   <th>   EMAIL    </th><th>JOBTYPE</th></tr>
<c:forEach items="${list }" var="list">
<%-- <tr><th><%=l.get(0) %></th> <th> <%=l.get(1) %></th> <th>  <%=l.get(2) %> </th> <th> <%=l.get(3) %> </th> <th><%=l.get(4) %></th><th> <%=l.get(5) %></th> <th><%=l.get(6) %> </th></tr>
 
  --%>
  <tr>
 	<td><c:out value="${list.id   }" /></td>
	<td><c:out value="${list.name }" /></td>
	<td><c:out value="${list.dob  }" /></td>
	<td><c:out value="${list.manager  }" /></td> 
	<td><c:out value="${list.location }" /></td>
	<td><c:out value="${list.email    }" /></td>
	<td><c:out value="${list.jobtype  }" /></td>
	</tr>
 </c:forEach>
</table>
</pre>
