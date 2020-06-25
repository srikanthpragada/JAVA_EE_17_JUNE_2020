<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="javax.sql.rowset.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Jobs</title>
</head>
<body>
	<h1>List of Jobs</h1>

	<%
	CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
	rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
	rowSet.setUsername("root");
	rowSet.setPassword("mysql");
	rowSet.setCommand("select * from jobs");
	rowSet.execute();

	while (rowSet.next()) {
		out.println(rowSet.getString("title") + "<p></p>" );
	}
	%>

</body>
</html>