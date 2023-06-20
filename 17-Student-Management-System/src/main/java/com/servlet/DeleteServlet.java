package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		StudentDAO dao = new StudentDAO(DBConnect.getConnection());

		boolean f = dao.deleteStudent(id);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("SuccessMSG", "Student Details Deleted Successfully");
			resp.sendRedirect("index.jsp");
//			System.out.println("Student Record Inserted Successfully");
		} else {
			session.setAttribute("ErrorMSG", "Something Went Wrong");
			resp.sendRedirect("index.jsp");
//			System.out.println("Something Went Wrong");

		}
	}

}
