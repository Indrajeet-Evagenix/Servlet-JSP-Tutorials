<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Function Tag Example</h1>
	<hr>
	<c:set var="str1" value="Welcome to The Becoder"></c:set>
	${fn:replace(str1,'to','Indrajeet') }

	<%-- <h1>JSTL Core Tag Example</h1>
	<hr>
	<c:out value="Indrajeet"></c:out>

	<c:import url="navbar.jsp" var="data"></c:import>
	<h1>
		<c:out value="${data }"></c:out>
	</h1>

	<hr>
	<c:set var="result" value="400*3" scope="session"></c:set>
	<h1>
		<c:out value="${result }"></c:out>
	</h1> --%>

	<%-- <hr>
	<c:set var="result" value="${ 25*3}" scope="session"></c:set>
	<h1>
		Before
		<c:out value="${result }"></c:out>
	</h1>

	<c:remove var="result" />
	<h1>After</h1>
	<c:out value="${result }"></c:out> --%>

	<%-- <c:catch var="exception">
		<%
		/* int num = 2 / 0; */
		String name = null;
		name.length();
		%>
	</c:catch>

	<c:if test="${exception!=null }">
		<p>${ exception}</p>
		<p>${ exception.message}</p>
	</c:if> --%>

	<%-- <c:set var="age" value="${16 }"></c:set>
	<c:if test="${age>15 }">
		<h1>Adult</h1>
	</c:if> --%>

	<%-- <c:set var="age" value="${12 }"></c:set>
	<c:choose>
		<c:when test="${age>10 }">
			<h1>Adult</h1>
		</c:when>
		<c:when test="${age<10 }">
			<h1>Chilled</h1>
		</c:when>
		<c:otherwise>
			<h1>Invalid Age</h1>
		</c:otherwise>

	</c:choose> --%>

	<%-- <c:forEach var="num" begin="1" end="10">
		<c:out value="${num }"></c:out>
	</c:forEach> --%>

	<%-- <c:forTokens items="Indrajeet-Kishanlal-Gupta-Coder" delims="-"
		var="newString">
		<c:out value="${newString }"></c:out>
	</c:forTokens>

	<c:forTokens items="Indrajeet,Kishanlal,Gupta,Coder" delims=","
		var="newString">
		<c:out value="${newString }"></c:out>
	</c:forTokens> --%>

	<%-- <c:url value="/index.jsp" var="pageUrl">
		<c:param name="em" value="demo@gmail.com"></c:param>
		<c:param name="ps" value="demo"></c:param>
	</c:url>
	${pageUrl } --%>

	<%-- <c:redirect url="https://www.google.com"></c:redirect> --%>





</body>
</html>