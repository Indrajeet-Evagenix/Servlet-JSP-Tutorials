package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dao.EmployeeSkillMasterDao;
import database.DBConnection;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		DBConnection dbConnection = null;
		Connection connection = null;

		try {
			dbConnection = new DBConnection();
			connection = dbConnection.getConnection();

			EmployeeSkillMasterDao daoEmployeeSkill = new EmployeeSkillMasterDao(connection);
			boolean flag = daoEmployeeSkill.deleteSkillByEmployeeId(id);

			EmployeeDao dao = new EmployeeDao(connection);
			boolean f = dao.deleteEmployee(id);

			if (f && flag) {
				System.out.println("Record Deleted Successfully");
				response.sendRedirect("AllEmployeeDetails.jsp");
			} else {
				System.out.println("Something Went Wrong");
				response.sendRedirect("ErrorMsgDelete.jsp");
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
