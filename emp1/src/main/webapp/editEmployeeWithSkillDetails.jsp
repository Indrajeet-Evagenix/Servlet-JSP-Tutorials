<%@page import="dao.EmployeeSkillMasterDao"%>
<%@page import="entity.SkillMaster"%>
<%@page import="java.util.List"%>
<%@page import="dao.SkillDao"%>
<%@page import="entity.Employee"%>
<%@page import="dao.EmployeeDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="database.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditEmployee</title>
</head>
<body>
	<h1>Edit Employee Details</h1>

	<%
	DBConnection dbConnection = null;
	Connection connection = null;
	EmployeeDao employeeDao = null;
	Employee employee = null;
	try {

		dbConnection = new DBConnection();
		connection = dbConnection.getConnection();
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDao = new EmployeeDao(connection);
		employee = employeeDao.getEmployeeById(id);
	%>

	<%
	} catch (Exception exception) {
	exception.printStackTrace();

	}
	%>
	<%
	String maleGenderChecked = " ";
	String femaleGenderChecked = " ";

	if (employee.getGender() == 1) {
		maleGenderChecked = " checked ";
	} else if (employee.getGender() == 2) {
		femaleGenderChecked = " checked ";
	}
	%>
	<form action="update" method="post">

		<input type="text" name="ename" placeholder="Enter Your Name"
			value="<%=employee.getName()%>" required="required"><br>
		<br>
		<textarea name="address" rows="6" cols="15"
			placeholder="Enter Your Address" required="required"><%=employee.getAddress()%></textarea>
		<br> <br> <label>Gender:</label> <input type="radio"
			name="gender" value="<%=employee.getGender()%>" required="required"
			<%=maleGenderChecked%>>Male <input type="radio" name="gender"
			value="2" value="<%=employee.getGender()%>" required="required"
			<%=femaleGenderChecked%>>Female<br> <br> <input
			type="number" name="salary" placeholder="Enter Your Salary"
			value="<%=employee.getSalary()%>" required="required"><br>
		<br> <input type="date" name="birthdate"
			value="<%=employee.getBirthDate()%>" required="required"> <br>
		<br> <label>Skills:</label> <br> <br>

		<%
		try {

			String isChecked = " ";
			EmployeeSkillMasterDao employeeSkillMasterDao = new EmployeeSkillMasterDao(connection);
			List<Integer> empSkillMasterId_list = employeeSkillMasterDao.getSkillIdbyEmployeeId(employee.getEmployeeId());
			SkillDao skillDao = new SkillDao(connection);
			List<SkillMaster> allSkill_list = skillDao.listOfSkills();
			for (SkillMaster skill : allSkill_list) {//skill master
				/* System.out.println("Start of Skill: "+skill); */

				isChecked = " ";
				for (Integer skillMasterId : empSkillMasterId_list) {//emp skill 
			if (skillMasterId == skill.getSkilMasterId()) {
				isChecked = " checked ";
				break;
			}

				}
		%>
		<input type="checkbox" name="course" <%=isChecked%>
			value="<%=skill.getSkilMasterId()%>">
		<%=skill.getName()%>

		<br>
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

		<input type="hidden" name="id" value="<%=employee.getEmployeeId()%>">
		<br>
		<button type="submit">Submit</button>

	</form>



</body>
</html>