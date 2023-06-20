<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: red">

<%@include file="header.jsp" %>

	 <h1>Hello JSP First Page</h1>
	<h1>Declaration Tag</h1>
	<%!int a = 50;
	String name = "Indrajeet";%>

	<h1>Expression Tag</h1>
	<%=a%><%=name%>

	<h1>Scripting Tag</h1>
	<%
	int sum = 20 + 30;
	out.println("Sum: " + sum);

	int sub = sum - 10;
	out.println("Sum: " + sub);
	%>
	<h1 style="background-color: green">
		Sum=<%=sum%></h1>
	<h1>
		Sum=<%=sub%></h1> 
		
		<h1>Time: <%=new Date().toString() %></h1>
</body>
</html>