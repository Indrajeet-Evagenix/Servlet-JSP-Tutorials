package com.Servlets;

import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("name");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		byte newGender = (byte) gender;
		Double salary = Double.parseDouble(request.getParameter("salary"));
		String birthdate = request.getParameter("birthdate");// 1998-04-29
		Date userDate = DateCoversion.parseUserInput(birthdate);
		java.sql.Date sqlDate = DateCoversion.convertToSqlDate(userDate);

		Employee employee = new Employee(userName, address, newGender, salary, sqlDate);

		EmployeeDao employeeDao = new EmployeeDao(DBConnect.getConnection());

		boolean f = employeeDao.registerEmployee(employee);

		HttpSession session = request.getSession();

		if (f) {
			session.setAttribute("SuccessMSG", "Employee Record Inserted Successfully");
			response.sendRedirect("register.jsp");
			System.out.println("Employee Record Inserted Successfully");
		} else {
			session.setAttribute("ErrorMSG", "Something Went Wrong");
			response.sendRedirect("register.jsp");
			System.out.println("Something Went Wrong");
		}
	}
}
