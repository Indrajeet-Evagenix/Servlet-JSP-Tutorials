package com.Servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DbConnect.DBConnect;
import com.EmployeeDao.EmployeeDao;
import com.Entity.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("name");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		byte newGender = (byte) gender;
		Double salary = Double.parseDouble(request.getParameter("salary"));
		String birthdate = request.getParameter("birthdate");// 1998-04-29
		Date userDate = DateCoversion.parseUserInput(birthdate);
		java.sql.Date sqlDate = DateCoversion.convertToSqlDate(userDate);

		int id = Integer.parseInt(request.getParameter("id"));

		Employee employee = new Employee(id, userName, address, newGender, salary, sqlDate);
		System.out.println(employee);
		EmployeeDao employeeDao = new EmployeeDao(DBConnect.getConnection());

		HttpSession session = request.getSession();

		boolean f = employeeDao.updateEmployee(employee);

		if (f) {
			session.setAttribute("SuccessMSG", "Employee Details Updated Successfully");
			response.sendRedirect("index.jsp");
			System.out.println("Employee Record Updated Successfully");
		} else {
			session.setAttribute("ErrorMSG", "Something Went Wrong");
			response.sendRedirect("index.jsp");
			System.out.println("Something Went Wrong");
		}
	}

}
