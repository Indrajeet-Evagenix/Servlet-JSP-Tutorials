package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.dbconnect.DbConnect;
import com.entity.Employee;

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

		String fname = request.getParameter("fname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(password);
		System.out.println(email);

		Employee employee = new Employee(fname, email, password);

		EmployeeDao employeeDao = new EmployeeDao(DbConnect.getConnection());
		HttpSession session = request.getSession();

		boolean f = employeeDao.registerEmployee(employee);

		if (f) {
			System.out.println("Record Inserted");
			session.setAttribute("username", employee);
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("Not Inserted");
			response.sendRedirect("login.jsp");
		}
	}

}
