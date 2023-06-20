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
import com.entity.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");

		int id = Integer.parseInt(req.getParameter("id"));

		Student student = new Student(id, name, dob, address, qualification, email);

		System.out.println(student);

		StudentDAO dao = new StudentDAO(DBConnect.getConnection());

		HttpSession session = req.getSession();
		
		boolean f = dao.updateStudent(student);

		if (f) {
			session.setAttribute("SuccessMSG", "Student Details Updated Successfully");
			resp.sendRedirect("index.jsp");
//			System.out.println("Student Record Inserted Successfully");
		} else {
			session.setAttribute("ErrorMSG", "Something Went Wrong");
			resp.sendRedirect("index.jsp");
//			System.out.println("Something Went Wrong");
		}

	}

}
