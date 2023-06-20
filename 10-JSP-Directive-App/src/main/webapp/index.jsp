<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Taglib Directive Example</h1>
	<hr>
	<c:set var="name" value="BeCoder"></c:set>

	<c:out value="${name}"></c:out>

	<c:if test="${3>20 }">
		<h1>True Block</h1>
	</c:if>
	
	

</body>
</html>