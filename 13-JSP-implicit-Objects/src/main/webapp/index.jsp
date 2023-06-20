<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 1. JSP out Implicit Object -->
	<%-- <%
	out.print("Hello JSP");
	%> --%>

	<!-- 2. JSP Implicit Object -->
	<!-- <form action="next.jsp">
		<input type="text" name="username">
		<button type="submit">OK</button>
	</form>  -->

	<!-- 6. Session Implicit Object -->
	<%
	session.setAttribute("myname", "Indrajeet");
	%>

	<!-- 4. JSP Config Implicit Object -->
	<form action="welcome">
		<input type="text" name="username">
		<button type="submit">OK</button>
	</form>

	<!-- 7. JSP pageContext Implicit Object -->
	<!-- 8. JSP Page Implicit Object -->
	<!-- 4. JSP Exception Implicit Object -->

</body>


</html>