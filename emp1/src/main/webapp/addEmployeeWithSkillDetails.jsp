<%@page import="entity.SkillMaster"%>
<%@page import="java.util.List"%>
<%@page import="dao.SkillDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="database.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function ageCheck() {
		let dt = document.getElementById("dob").value;
		let birthdate = new Date(dt);
		/* console.log(birthdate); */
		let currentDate = new Date();
		/* console.log(currentDate); */
		let age = currentDate.getFullYear() - birthdate.getFullYear();
		/* console.log(age); */
		if (age < 15) {
			alert("! Age must be greater then 15 year");
			return false;
		}
		return true;
	}
</script>

<style type="text/css">
p {
	color: red;
}
</style>
</head>
<body>
	<h1>Add Employee Details</h1>
	<c:if test="${not empty SuccessMSG }">
		<p>${SuccessMSG }</p>
		<c:remove var="SuccessMSG" />
	</c:if>
	<c:if test="${not empty ErrorMSG }">
		<p>${ErrorMSG }</p>
		<c:remove var="ErrorMSG" />
	</c:if>
	<%
	String str=" ";
	if(str.length()<=9 && str.length()>3){
		
	}
	%>
	<form action="add" method="post" onsubmit="return ageCheck()">
		<input type="text" name="ename" placeholder="Enter Your Name"
			required="required"><br> <br>
		<textarea name="address" rows="6" cols="15" maxlength="150"
			placeholder="Enter Your Address" required="required"></textarea>
		<br> <br> <label>Gender:</label> <input type="radio"
			name="gender" value="1" required="required">Male <input
			type="radio" name="gender" value="2" required="required">Female<br>
		<br> <input type="number" name="salary"
			placeholder="Enter Your Salary" id="sal" maxlength="999999"
			required="required" maxlength="3"><br> <br> <label>Birthday:</label><input
			type="date" name="birthdate" id="dob" required="required"> <br>
		<br> <label>Skills:</label> <br> <br>
		<%
		DBConnection dbConnection = null;
		Connection connection = null;

		try {
			dbConnection = new DBConnection();
			connection = dbConnection.getConnection();

			SkillDao dao = new SkillDao(connection);
			List<SkillMaster> list = dao.listOfSkills();

			for (SkillMaster skill : list) {
		%>
		<input type="checkbox" name="course"
			value="<%=skill.getSkilMasterId()%>"><%=skill.getName()%><br>


		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		try {
		if (dbConnection != null) {
			dbConnection.close();
			dbConnection = null;
		}
		} catch (Exception exception2) {
		exception2.printStackTrace();
		}

		}
		%>


		<br>
		<button type="submit">Submit</button>

	</form>
</body>
</html>