<%@page import="com.entity.Employee"%>
<%@page import="com.dbconnect.DbConnect"%>
<%@page import="com.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="external.css">
</head>
<body>
	<h1>Index Page</h1>
	<%-- <%
	int id = Integer.parseInt(request.getParameter("id"));
	EmployeeDao employeeDao = new EmployeeDao(DbConnect.getConnection());
	Employee employee = employeeDao.getStudentById(id);
	%> --%>
	<div class="center-form container">

		<%-- <form action="" method="get">
			<h2>
				Welcome:
				<%
			employee.getFname();
			%>
			</h2>
			<input type="hidden" name="id" value="<%=employee.getId()%>">
		</form> --%>
		<h2>${username.fname }</h2>
		<ul>
			<li><a href="about.jsp">About-Page</a></li>
			<li><a href="contact.jsp">Contact-Page</a></li>
			<li><a href="login.jsp">Logout</a></li>
		</ul>
	</div>
</body>
</html>