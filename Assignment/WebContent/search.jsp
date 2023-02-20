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
<h1>Find Employee</h1>

<html:form action="addempfind" method="post">
<pre>
<bean:message key="id"/>          <html:text property="id"/>
<bean:message key="name"/>          <html:text property="name"/>

<html:submit property="empfind"> <bean:message key="empfind"/></html:submit>


</pre>

</html:form>