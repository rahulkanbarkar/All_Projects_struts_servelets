<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>Search Employee</h1>

<html:form action="addempfind" method="post">
<pre>
<bean:message key="id"/>          <html:text property="id"/>
<bean:message key="name"/>        <html:text property="name"/>


<html:submit property="empfind"> <bean:message key="empfind"/></html:submit>


</pre>

</html:form>