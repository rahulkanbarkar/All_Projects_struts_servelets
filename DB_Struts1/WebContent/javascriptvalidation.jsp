<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<html:form action="empcrud" method="post"   onsubmit="return validateForm()"> 
  <html:text property="username" />
  <html:text property="password" />
  <html:submit value="Login" />
</html:form>

<script type="text/javascript">
function validateForm() {
  var username = document.forms[0].elements["username"].value;
  var password = document.forms[0].elements["password"].value;

  if (username == "") {
    alert("Username is required");
    return false;
  }

  if (password == "") {
    alert("Password is required");
    return false;
  }

  return true;
}
</script>


</body>
</html>