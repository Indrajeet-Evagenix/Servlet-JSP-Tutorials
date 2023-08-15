<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 id="register">Register Page</h1>

	<form action="register" method="post">
		<label for="">Enter Your Full Name</label><br> <input type="text"
			placeholder="Enter Your Full Name" name="fname" id="fname"><br>
		<br> <label for="">Enter Your Email</label><br> <input
			type="email" placeholder="Enter Your Email" name="email" id="email"><br>
		<br> <label for="">Enter Your Password</label><br> <input
			type="password" placeholder="Enter Your password" name="password"
			id="password">
		<button type="submit">Register</button>
		<p>
			Already have an Account. <a href="login.jsp">Login
				here</a>
		</p>
	</form>
</body>
</html>