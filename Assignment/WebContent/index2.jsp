<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>Delete Employee Record</h1>

<html:form action="addempdelete" method="post">
<pre>
<bean:message key="id"/>          <html:text property="id"/>


<html:submit property="empdelete"> <bean:message key="empdelete"/></html:submit>


</pre>

</html:form><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>