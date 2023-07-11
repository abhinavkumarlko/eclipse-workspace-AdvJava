<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="topic" items="${topics}">
		<p><a href="getComments?tid=${topic.tid}"> ${topic.tname}</a> <br/> ${topic.tdesc } </p> 
	</c:forEach>

</body>
</html>