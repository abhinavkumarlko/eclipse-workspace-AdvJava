<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Elements</title>
</head>
<body>
	
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("HH");
	String hours = sdf.format(Calendar.getInstance().getTime());
		int hh = Integer.parseInt(hours);
	    if(hh < 12)
	    {   %>
	    	<%= "<h1> GOOD MORNING </h1>" %>
	   <% }
	    else if(hh >= 12 && hh <= 16)
	    {  %>
	    	<%= "<h1> GOOD AFTERNOON </h1>" %>
	    <% }
	    else if(hh > 16 && hh <= 21)
	    { %>
	    	<%= "<h1> GOOD EVENING </h1>" %>
	    <%}
	    else
	    { %>
	    	<%= "<h1> GOOD NIGHT </h1>" %>
       <% }    
	    
	%>

</body>
</html>