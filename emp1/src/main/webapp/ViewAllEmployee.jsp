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
	<h1>All Employee Details</h1>


	<table id="myTable">
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

			<c:forEach var="emp" items="${employeeList}">
				<tr>
					<td>${emp.name}</td>
					<td>${emp.address}</td>
					<td><c:if test="${emp.gender eq 1}">
							<%="Male"%>
						</c:if> <c:if test="${emp.gender eq 2}">
							<%="Female"%>
						</c:if></td>
					<td>${emp.salary}</td>
					<td>${emp.birthDate}</td>
					<td><a
						href="editEmployeeWithSkillDetails.jsp?id=${emp.employeeId}">Update</a>
						<a href="delete?id=${emp.employeeId}"
						onclick="return confirmDelete()">Delete</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>

	<%--For displaying Previous link except for the 1st page --%>
	<c:if test="${currentPage >= 2}">
		<td><a href="paginationServlet?page=${currentPage - 1}">Previous</a>
		</td>
	</c:if>

	<br>
	<br>

	<%--For displaying Next link --%>
	<c:if test="${currentPage < noOfPages }">
		<td><a href="paginationServlet?page=${currentPage + 1}">Next</a></td>
	</c:if>

	<%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>


	<%-- <br>
	<table border="1">
		<tr>
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i }">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="paginationServlet?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table> --%>



</body>
</html>