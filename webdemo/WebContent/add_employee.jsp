<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.sql.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>

<h1>Add Employee</h1>
    <a href="list_employees.jsp">List Employees</a>
    <p></p>
	<form action="add_employee.jsp">
		Fullname <br /> 
		<input type="text" name="fullname" required value="${param.fullname}" />
		<p></p>
		Job <br /> 
		<input type="text" name="job" required value="${param.job}" />
		<p></p>
		Salary <br /> 
		<input type="number" name="salary" required  value="${param.salary}" />
		<p></p>
		<input type="submit" value="Add Employee" />
	</form>

    <%
    // Get input from HTML form 
 	String fullname = request.getParameter("fullname");
    if(fullname == null)  // first request 
        return;  
    
    String job = request.getParameter("job");
 	String salary = request.getParameter("salary");
 	
    // Update Database 
 	Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver 
 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql");
 	PreparedStatement ps = con.prepareStatement
 			("insert into employees(fullname,salary,job) value(?,?,?)");
 	ps.setString(1,fullname); 
 	ps.setInt(2, Integer.parseInt(salary)); 
 	ps.setString(3,job);
 	
 	try {
 	   ps.executeUpdate();
	   out.println("<h2>Added employee successfully!</h2>");
 	}
 	catch(Exception ex) {
 		System.out.println(ex);
 		out.println("<h2>Sorry! Could not add due to error!</h2>");
 	}
 	ps.close();
    con.close();
	  
    %>
</body>
</html>