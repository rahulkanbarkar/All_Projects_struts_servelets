<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>Upload Reports]</h1>

<html:form action="uploadfile" method="post">
<pre>
<bean:message key="id"/>          <html:text property="id"/>
<bean:message key="file"/>        <html:text property="file"/>


<html:submit property="empfind"> <bean:message key="empfind"/></html:submit>


</pre>

</html:form>