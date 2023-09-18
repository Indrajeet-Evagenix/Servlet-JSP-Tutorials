package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dao.EmployeeSkillMasterDao;
import database.DBConnection;
import entity.Employee;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("ename");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		byte genderValue = (byte) gender;
		Double salary = Double.parseDouble(request.getParameter("salary"));
		String birthdate = request.getParameter("birthdate");
		Date userDate = DateConversion.parseUserInput(birthdate);
		java.sql.Date sqlDate = DateConversion.convertToSqlDate(userDate);

		String[] skill = request.getParameterValues("course");
		byte[] skillMasterId = StringToByteConversion.stringToByte(skill);
//		System.out.println(Arrays.toString(skillMasterId));

		Employee employee = new Employee(id, name, address, genderValue, salary, sqlDate, skillMasterId);
//		System.out.println(employee);

		DBConnection dbConnection = null;
		Connection connection = null;
		EmployeeSkillMasterDao daoEmployeeSkill = null;

		try {
			dbConnection = new DBConnection();
			connection = dbConnection.getConnection();

			EmployeeDao dao = new EmployeeDao(connection);
			boolean f = dao.updateEmployeeDetails(employee);

			EmployeeSkillMasterDao dao2 = new EmployeeSkillMasterDao(connection);
			dao2.deleteSkillByEmployeeId(employee.getEmployeeId());

			for (int i = 0; i < employee.getSkillMasterId().length; i++) {
				daoEmployeeSkill = new EmployeeSkillMasterDao(connection);
				daoEmployeeSkill.addSkills(employee.getEmployeeId(), employee.getSkillMasterId()[i]);
//				System.out.println(employee.getSkillMasterId()[i]);

			}

			if (f) {
				System.out.println("Record Updated Successfully");
				response.sendRedirect("UpdateSuccessMsg.jsp");
			} else {
				System.out.println("Something Went Wrong");
				response.sendRedirect("ErrorMsgUpdate.jsp");
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
	}

}
