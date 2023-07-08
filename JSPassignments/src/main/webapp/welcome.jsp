<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Assignment</title>
</head>
<body>
	<%-- using html --%> 
	<h1> Welcome to JSP </h1>

	<%-- using template text --%> 
	Welcome to jsp
	
	<%-- using Scriplet --%> 
	<% 
		String nm="Abhinav";
		out.print("<h1> Welcome "+nm+"</h1>");
	%>
	
	
	
	
</body>
</html>