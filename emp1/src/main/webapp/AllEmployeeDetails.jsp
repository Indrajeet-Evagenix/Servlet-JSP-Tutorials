<%@page import="entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="database.DBConnection"%>
<%@page import="dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<script>
	function confirmDelete() {
		return confirm("Are you sure you want to delete employee ?");
	}
</script>

</head>
<body>
	<br>
	<a href="addEmployeeWithSkillDetails.jsp">Click Here to Add
		Employee Record</a>
	<br>

	<br>
	<!-- <a href="ViewAllEmployee.jsp">Click Here to Go Pagination Page</a> -->
	<br>

	<c:if test="${currentPage <= noOfPages }">
		<a href="paginationServlet?page=${currentPage + 1}">Click Here to Go Pagination Page</a>
	</c:if>

	<br>



	<h1>All Employee Details</h1>
	<table>
		<thead>
			<tr>
				<th>Full Name</th>
				<th scope="col">Address</th>
				<th scope="col">Gender</th>
				<th scope="col">Salary</th>
				<th scope="col">BirthDate</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>

			<%
			DBConnection dbConnection = null;
			Connection connection = null;
			try {
				dbConnection = new DBConnection();
				connection = dbConnection.getConnection();
				EmployeeDao dao = new EmployeeDao(connection);
				List<Employee> list = dao.allEmployeeDetails();

				for (Employee emp : list) {
			%>
			<tr>
				<td><%=emp.getName()%></td>
				<td><%=emp.getAddress()%></td>
				<td>
					<%
					String gender = Integer.toString(emp.getGender());
					if (gender.equals("1")) {
						out.print("Male");
					} else {
						out.print("Female");
					}
					%>
				</td>
				<td><%=emp.getSalary()%></td>
				<td><%=emp.getBirthDate()%></td>
				<td><a
					href="editEmployeeWithSkillDetails.jsp?id=<%=emp.getEmployeeId()%>">Update</a>
					<a href="delete?id=<%=emp.getEmployeeId()%>"
					onclick="return confirmDelete()">Delete</a>
			</tr>
			<%
			}
			} catch (Exception exception) {
			exception.printStackTrace();

			} finally {
			try {
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
			} catch (Exception exception2) {
			exception2.printStackTrace();
			}

			}
			%>
		</tbody>
	</table>

</body>
</html>