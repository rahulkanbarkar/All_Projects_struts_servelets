<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<h1><bean:message key="title"/></h1>
<html:errors />
<html:form  action="addemp"  method="post"  onsubmit="return validateform()">
<pre>

<bean:message key="id" />          <html:text property="id" styleId="id" />

<bean:message key="name" />        <html:text  property="name" styleId="name"/>

<bean:message key="dob" />         <html:text property="dob"/>
<bean:message key="manager"/>     <html:text property="manager"/>
<bean:message key="location" />    <html:text property="location"/>
<bean:message key="email" />       <html:text property="email"/>
<bean:message key="jobtype"/>      <html:text property="jobtype"/>
<html:submit property="empsave">   <bean:message key="empsave"/></html:submit>




</pre>

</html:form>
<script>
function validateform(){  
	alert("Name can't be blank1"); 
	const NAME = document.querySelector('#name');
	form.addEventListener('submit', function (e) {
	    e.preventDefault();

	});
	}

	
}
	
</script>
</html>