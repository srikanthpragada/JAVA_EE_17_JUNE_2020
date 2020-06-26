<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Jobs</title>
</head>
<body>
	<h1>List of Jobs</h1>

	<table border="1" cellpadding="5pt">
		<tr style="background-color:blue;color:white;font-weight:bold"> 
			<th>Job Title</th>
			<th>Min Salary</th>
		</tr>

		<%
		Class.forName("com.mysql.jdbc.Driver"); // Load JDBC Driver 
		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
		rowSet.setUsername("root");
		rowSet.setPassword("mysql");
		rowSet.setCommand("select * from jobs");
		rowSet.execute();

		while (rowSet.next()) {
			out.println(String.format("<tr><td>%s</td><td style='text-align:right'>%d</td></tr>", rowSet.getString("title"), rowSet.getInt("minsal")));
		}
		%>
	</table>
</body>
</html>