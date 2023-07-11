<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
</head>
<body>
	<h3> <i>Comments</i> </h3>
	<c:forEach var="comment" items="${comments}">
		
		<p  style="width:70%; height:30px; background-color: beige "> <span style="color: red"> ${comment.uid } : </span> ${comment.cmt } </p> 
	</c:forEach>

</body>
</html>