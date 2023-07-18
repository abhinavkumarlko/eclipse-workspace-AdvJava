<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Portal</title>
</head>
<body>
	<form action="http://localhost:8080/AdvJavaEndModule/student" method="post" >
		
		Enter name : <input type="text" name="sname" />
		<br/>
		Enter email : <input type="text" name="email" />
		<br/>
		Enter contact : <input type="text" name="contact" />
		<br/>
		Enter marks for sem1 : <input type="text" name="sem1" />
		<br/>
		Enter marks for sem2 : <input type="text" name="sem2" />
		<br/>
		Enter marks for sem3 : <input type="text" name="sem3" />
		<br/>
		Enter marks for sem4 : <input type="text" name="sem4" />
		<br/>
		
		<input type="submit" value="SUBMIT" /> 
	</form>
</body>
</html>