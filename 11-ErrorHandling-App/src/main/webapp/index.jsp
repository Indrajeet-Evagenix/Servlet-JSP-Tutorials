<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page errorPage="error_page.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Home Page</h1>
	<%-- <%
	String name = null;
	name.length();
	%> --%>
	<%
	String name1 = "Indrajeet";
	int l = name1.length();
	%>
	<%="Length: " + l%>
</body>
</html>