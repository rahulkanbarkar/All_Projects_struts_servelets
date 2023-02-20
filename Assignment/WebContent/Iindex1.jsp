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

<html:form action="addempupdate" method="post">
<pre>
<bean:message key="id"/>          <html:text property="id"/>
<bean:message key="name"/>        <html:text property="name"/>
<bean:message key="dob"/>         <html:text property="dob"/>
<bean:message key="location"/>    <html:text property="location"/>
<bean:message key="manager"/>     <html:text property="manager"/>
<bean:message key="email"/>       <html:text property="email"/>
<bean:message key="jobtype"/>      <html:text property="jobtype"/>

<html:submit property="empupdate"> <bean:message key="empupdate"/></html:submit>


</pre>

</html:form>