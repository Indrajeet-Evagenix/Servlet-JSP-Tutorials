package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import database.DBConnection;
import entity.Employee;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/paginationServlet")
public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		int recordPerPage = 5;
		List<Employee> list = null;

		int page2 = Integer.parseInt(request.getParameter("page"));

		if (page2 >= 2) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		DBConnection dbConnection = null;
		Connection connection = null;
		try {
			dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			EmployeeDao empDao = new EmployeeDao(connection);

			list = empDao.viewAllEmployeePerPage(page, recordPerPage);
//			System.out.println(list);
			int noOfRecords = empDao.getNoOfRecords();
//			System.out.println("Number of Records" + noOfRecords);
//			System.out.println(noOfRecords*1.0 / recordPerPage);
			int noOfPage = (int) Math.ceil(noOfRecords * 1.0 / recordPerPage);
			System.out.println("total page: " + noOfPage);

			request.setAttribute("employeeList", list);
			request.setAttribute("noOfPages", noOfPage);
			request.setAttribute("currentPage", page);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllEmployee.jsp");
			requestDispatcher.forward(request, response);
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
