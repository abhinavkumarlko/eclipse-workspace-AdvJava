<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<f:form action ="" modelAttribute="edit_emp">
		Empid :<f:input path="empid" /><br/>
		Emp name :<f:input path="ename" /><br/>
		Dept no :<f:input path="deptno" /><br/>
		Salary :<f:input path="salary" /><br/>
		<input type="submit" value="Update details" />
	</f:form>
		
</body>
</html>