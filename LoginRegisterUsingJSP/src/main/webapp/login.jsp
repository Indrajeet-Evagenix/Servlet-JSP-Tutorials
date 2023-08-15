<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 id="register">Login Page</h1>

	<form action="login" method="post">
		<label for="">Enter Your Email</label><br> <input type="email"
			placeholder="Enter Your Email" name="email" id="email"><br>
		<br> <label for="">Enter Your Password</label><br> <input
			type="password" placeholder="Enter Your password" name="password"
			id="password">
		<button type="submit">Login</button>
		<p>
			New User Please Create Account. <a href="register.jsp">Register
				here</a>
		</p>
	</form>
</body>
</html>