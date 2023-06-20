<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="t"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1>Greet MSG</h1>
	<hr>
	<t:greet></t:greet>
	<hr> --%>

	<h1>Greet MSG</h1>
	<hr>
	<t:greet msg="Good Afternoon"></t:greet>
	<hr>

	<h1>Welcome to Demo Page</h1>
	<hr>
	<t:demo side="5"></t:demo>
</body>
</html>