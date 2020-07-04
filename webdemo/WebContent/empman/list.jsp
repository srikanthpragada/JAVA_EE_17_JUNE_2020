<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
</head>
<%@include file="header.html"%>
<body>
	<h2>Employees</h2>
	<table border="1" cellpadding="5pt" style="width: 100%">
		<tr style="background-color: black; color: white; font-weight: bold">
			<th>Id</th>
			<th>Fullname</th>
			<th>Job</th>
			<th>Salary</th>
			<th></th>
		</tr>

		<%
			Class.forName("com.mysql.jdbc.Driver"); // Load JDBC Driver 
		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
		rowSet.setUsername("root");
		rowSet.setPassword("mysql");
		rowSet.setCommand("select * from employees order by 1");
		rowSet.execute();

		while (rowSet.next()) {
		%>

		<tr>
			<td><%=rowSet.getInt("id")%></td>
			<td><%=rowSet.getString("fullname")%></td>
			<td><%=rowSet.getString("job")%></td>
			<td style='text-align: right'><%=rowSet.getString("salary")%></td>
			<td style="text-align:center"><a href='edit.jsp?id=<%=rowSet.getInt("id")%>'>Edit</a> <a
				href='delete.jsp?id=<%=rowSet.getInt("id")%>'>Delete</a></td>

		</tr>
		<%
			}
		%>
	</table>
</body>
</html>