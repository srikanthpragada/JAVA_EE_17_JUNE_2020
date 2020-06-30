<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prime Number</title>
</head>
<body>

	<jsp:useBean id="primeBean" class="beans.PrimeBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="primeBean" />
	<%
		primeBean.detect();
	%>
	
	<h2>${primeBean.message}</h2>



</body>
</html>