<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

 <sql:setDataSource 
    var="mysql" 
    driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/hr" 
	user="root" 
	password="mysql" />

<c:if test="${!empty param.jobid}">

	<sql:query var="emplist" dataSource="${mysql}">
      select *
      from employees
      where job = ?
      <sql:param value="${param.jobid}" />
	</sql:query>

	<h2>Employees of Job [${param.jobid}]</h2>

	<c:if test='${emplist.rowCount == 0}'>
		<h3>Sorry! No Employees Found!</h3>
	</c:if>

	<ul>
		<c:forEach var="emp" items="${emplist.rows}">
			<li>${emp.id},${emp.fullname},${emp.salary}
		</c:forEach>
	</ul>

</c:if>

<c:if test="${empty param.jobid}">
Sorry! Missing Job id. Please provide a parameter jobid.
</c:if>