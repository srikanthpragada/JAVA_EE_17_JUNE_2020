<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Page</title>
</head>
<body>
<h1>First Page</h1>
<%
    response.sendRedirect("p2.jsp?num=1000");
%>

</body>
</html>