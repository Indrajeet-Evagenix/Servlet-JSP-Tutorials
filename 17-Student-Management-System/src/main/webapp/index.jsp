<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<%-- <%
	Connection conn = DBConnect.getConnection();
	/* out.print(conn); */
	%> --%>

	<div class="container p-5">
		<div class="card">
			<div class="card-body">
				<p class="text-center fs-1">All Student details</p>

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
							<th scope="col">DOB</th>
							<th scope="col">Address</th>
							<th scope="col">Qualification</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						StudentDAO dao = new StudentDAO(DBConnect.getConnection());
						List<Student> list = dao.getAllStudent();

						for (Student s : list) {
						%>

						<tr>
							<th scope="row"><%=s.getFullName()%></th>
							<td><%=s.getDob()%></td>
							<td><%=s.getAddress()%></td>
							<td><%=s.getQualification()%></td>
							<td><%=s.getEmail()%></td>
							<td><a href="edit_student.jsp?id=<%=s.getId()%>"
								class="btn btn-sm btn-primary">Edit</a> <a
								href="delete?id=<%=s.getId()%>"
								class="btn btn-sm btn-danger ms-1">Delete</a></td>
						</tr>

						<%
						}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>