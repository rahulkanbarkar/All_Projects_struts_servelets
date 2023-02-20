<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
<title>fileUpload</title>
 
</head>
<body>
   <html:errors />

 <html:form method="POST"  action="fileUpload" enctype="multipart/form-data">
       File: <html:file property="dataFile" />
       <html:submit property="method"  value="fileUploadAction"/>
      <!--  <input type="hidden" id="method" name="method"> -->
    </html:form>
 
</body>
</html>