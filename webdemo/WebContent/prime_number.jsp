<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prime Number Detection</title>
</head>
<body>
	<h1>Prime Number</h1>
	<form action="prime_number.jsp">
		Number : <input type="number" name="number" value="${param.number}" />
		<p></p>
		<input type="submit" value="Submit" />
	</form>

	<%
	String number = request.getParameter("number");
	if (number == null)
		return; // Terminate JSP

	int num = Integer.parseInt(number);
	boolean prime = true;

	for (int i = 2; i <= num / 2; i++)
		if (num % i == 0) {
			prime = false;
			break;
		}

	if (prime)
		out.println("<h2>Prime Number</h2>");
	else
		out.println("<h2>Not a Prime Number</h2>");
	%>
</body>
</html>