package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import database.DBConnection;
import entity.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("ename");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		byte genderValue = (byte) gender;
		Double salary = Double.parseDouble(request.getParameter("salary"));
		String birthdate = request.getParameter("birthdate");

		if (birthdate == null || birthdate.equals("")) {
			System.out.println("Please Select Birthdate Properly");
		}
		Date userDate = DateConversion.parseUserInput(birthdate);
//		System.out.println(userDate);
		java.sql.Date sqlDate = DateConversion.convertToSqlDate(userDate);

		if (name == null || name.equals("")) {
			System.out.println("Enter Proper Name");
		}
		if (address == null || address.equals("")) {
			System.out.println("Enter Address Details Properly");
		}
		if (salary == 0) {
			System.out.println("Please Enter Your Salary");
		}

//		System.out.println(name);
//		System.out.println(address);
//		System.out.println(genderValue);
//		System.out.println(salary);
//		System.out.println(sqlDate);

		String[] skill = request.getParameterValues("course");
		byte[] skillMasterId = StringToByteConversion.stringToByte(skill);
//		System.out.println(Arrays.toString(skillMasterId));

		Employee employee = new Employee(name, address, genderValue, salary, sqlDate, skillMasterId);
		System.out.println(employee);

		DBConnection dbConnection = null;
		Connection connection = null;

		try {
			dbConnection = new DBConnection();
			connection = dbConnection.getConnection();

			EmployeeDao dao = new EmployeeDao(connection);
			boolean f = dao.addEmployeeDetails(employee);

			HttpSession session = request.getSession();

			if (f) {
				System.out.println("Record Inserted Successfully");
				session.setAttribute("SuccessMSG", "Employee Record Inserted Successfully");
				response.sendRedirect("successMsg.jsp");
			} else {
				System.out.println("Something Went Wrong");
				session.setAttribute("ErrorMSG", "Something Went Wrong Please Try Again");
				response.sendRedirect("addEmployeeWithSkillDetails.jsp");
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
