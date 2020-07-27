<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
</head>
<body>
	<h2>Add Job</h2>
	<sf:form method="post" modelAttribute="job">
		Id : <sf:input path="id" type="text" required="true" />
		Title : <sf:input path="title" maxlength="20" required="true"  autocomplete="off" />
		<p></p>
		<input type="submit" Value="Add Job" />
	</sf:form>
	
	<h4>${message}</h4>

</body>
</html>