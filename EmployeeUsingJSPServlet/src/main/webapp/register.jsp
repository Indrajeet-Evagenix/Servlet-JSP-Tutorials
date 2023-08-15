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

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card p-2">
					<div class="card-body">
						<p class="fs-3 text-center">Add Employee</p>
						<c:if test="${not empty SuccessMSG }">
							<p class="text-center text-success">${SuccessMSG }</p>
							<c:remove var="SuccessMSG" />
						</c:if>
						<c:if test="${not empty ErrorMSG }">
							<p class="text-center text-success">${ErrorMSG }</p>
							<c:remove var="ErrorMSG" />
						</c:if>

						<form action="register" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									name="name" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label>
								<textarea name="address" class="form-control" rows="3" cols="2"></textarea>

							</div>
							<div class="form-group">
								<label>Gender</label>
								<div class="form-control">
									<label class="radio-inline"> <input type="radio"
										name="gender" value="1"> Male
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="2"> Female
									</label>
								</div>
							</div>
							<div class="mb-3">
								<label class="form-label">Date Of Birth</label> <input
									type="date" name="birthdate" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Salary</label> <input type="number"
									name="salary" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>