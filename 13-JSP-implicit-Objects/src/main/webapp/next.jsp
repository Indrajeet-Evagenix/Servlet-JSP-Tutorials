<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 3. JSP Response Implicit Object -->
	<%-- <%
	response.sendRedirect("https://www.google.com");
	%>

	<%
	String name = request.getParameter("username");
	out.print(name);
	%> --%>

	<%
	session.removeAttribute("myname");
	%>
	<%
	String name = (String) session.getAttribute("myname");
	out.print(name);
	%>
</body>

</html>