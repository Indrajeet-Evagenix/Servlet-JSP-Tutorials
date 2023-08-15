<%@page import="com.Entity.Employee"%>
<%@page import="com.EmployeeDao.EmployeeDao"%>
<%@page import="com.DbConnect.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-light">

	<%@include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card p-2">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Employee Details</p>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						EmployeeDao dao = new EmployeeDao(DBConnect.getConnection());
						Employee employee = dao.getEmployeeById(id);
						%>
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									value="<%=employee.getName()%>" name="name"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Enter Address</label>
								<textarea  name="address"
									class="form-control"><%=employee.getAddress()%></textarea>
							</div>
							<div class="form-group">
								<label>Gender</label>
								<div class="form-control">
									<label class="radio-inline"> <input type="radio"
										name="gender" value="<%=employee.getGender()%>"> Male
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="<%=employee.getGender()%>">
										Female
									</label>
								</div>
							</div>
							<div class="mb-3">
								<label class="form-label">Salary</label> <input type="number"
									value="<%=employee.getSalary()%>" name="salary"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">BirthDate</label> <input type="date"
									value="<%=employee.getBirthDate()%>" name="birthdate"
									class="form-control">
							</div>
							<input type="hidden" name="id"
								value="<%=employee.getEmployeId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>