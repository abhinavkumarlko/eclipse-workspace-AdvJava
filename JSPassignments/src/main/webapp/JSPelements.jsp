<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Elements</title>
</head>
<body>
	<h1>Welcome to JSP</h1>
	<!-- This is html comment -->
	<%-- this is Jsp Comment --%>

	<%-- This is Scriplet --%>	
	<%
	   int n = 0;
	   out.print("Value of n : "+(++n));
	%>
	
	<%-- This is Expression element --%>	
	<br/>
	<%  out.print(Calendar.getInstance().getTime()); %>
	<%= Calendar.getInstance().getTime()  %>
	<br/>
	
	<%-- This is Declaration element --%>	
	<%! int iVar;  %>
	<%= "value of iVar : "+(++iVar)  %>

</body>
</html>