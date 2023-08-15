<%@page import="com.EmployeeDao.EmployeeDao"%>
<%@page import="com.Entity.Employee"%>
<%@page import="com.DbConnect.DBConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<%@include file="all_css.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script>
	function confirmDelete() {
		return confirm("Are you sure you want to delete this item?");
	}
</script>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-5">
		<div class="card">
			<div class="card-body">
				<p class="text-center fs-1">All Employee details</p>

				<c:if test="${not empty SuccessMSG }">
					<p class="text-center text-success">${SuccessMSG }</p>
					<c:remove var="SuccessMSG" />
				</c:if>
				<c:if test="${not empty ErrorMSG }">
					<p class="text-center text-success">${ErrorMSG }</p>
					<c:remove var="ErrorMSG" />
				</c:if>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Address</th>
							<th scope="col">Gender</th>
							<th scope="col">Salary</th>
							<th scope="col">Birthdate</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						EmployeeDao dao = new EmployeeDao(DBConnect.getConnection());
						List<Employee> list = dao.getAllEmployee();

						for (Employee employee : list) {
							/* request.setAttribute("id", employee.getEmployeId()); */
						%>
						<tr>
							<th scope="row"><%=employee.getName()%></th>
							<td><%=employee.getAddress()%></td>
							<td><%=employee.getGender()%></td>
							<td><%=employee.getSalary()%></td>
							<td><%=employee.getBirthDate()%></td>
							<td><a
								href="edit_employee.jsp?id=<%=employee.getEmployeId()%>"
								class="btn btn-sm btn-primary">Edit</a> <a
								href="delete?id=<%=employee.getEmployeId()%>"
								class="btn btn-sm btn-danger ms-1"
								onclick="return confirmDelete()">Delete</a>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>