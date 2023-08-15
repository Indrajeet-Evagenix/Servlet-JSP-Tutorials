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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("doPost");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(password);
		System.out.println(email);

		Employee employee = new Employee(password, email);

		EmployeeDao employeeDao = new EmployeeDao(DbConnect.getConnection());
		HttpSession session = request.getSession();

		Employee f = employeeDao.loginEmployee(email, password);

		if (f != null) {
			System.out.println("Record Found");
			session.setAttribute("username", employee);
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("Record not Found");
			response.sendRedirect("login.jsp");
		}
	}

}
