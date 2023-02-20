<%@page import="java.util.List"%>

<pre>

<%
List l=(List)request.getAttribute("list");
for(Object o:l)
{
	out.println("\t"+o+"\t");
}
%>    
</pre>