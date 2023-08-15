package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DbConnect.DBConnect;
import com.EmployeeDao.EmployeeDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDao employeeDao = new EmployeeDao(DBConnect.getConnection());

		HttpSession session = request.getSession();

		boolean f = employeeDao.deleteEmployee(id);

		if (f) {
			session.setAttribute("SuccessMSG", "Employee Details Deleted Successfully");
			response.sendRedirect("index.jsp");
			System.out.println("Employee Record Deleted Successfully");
		} else {
			session.setAttribute("ErrorMSG", "Something Went Wrong");
			response.sendRedirect("index.jsp");
			System.out.println("Something Went Wrong");

		}

	}

}
