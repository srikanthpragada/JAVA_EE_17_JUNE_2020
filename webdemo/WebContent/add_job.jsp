<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.sql.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
</head>
<body>

<h1>Add Job</h1>
	<form action="add_job.jsp">
		Id <br /> 
		<input type="text" name="id" required value="${param.id}" />
		<p></p>
		Title <br /> 
		<input type="text" name="title" required value="${param.title}" />
		<p></p>
		Min. Salary <br /> 
		<input type="number" name="minsal" required  value="${param.minsal}" />
		<p></p>
		<input type="submit" value="Add Employee" />
	</form>

    <%
    // Get input from HTML form 
 	String id = request.getParameter("id");
    if(id == null)  // first request 
        return;  
    %>
    
    <jsp:useBean id="jobBean" scope="page" class="beans.JobBean" />
    <jsp:setProperty name="jobBean" property="*" />
    <h2>${jobBean.message}</h2>
    
</body>
</html>