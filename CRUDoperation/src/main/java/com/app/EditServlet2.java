
package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Stu e1 = new Stu();
		e1.setId(id);
		e1.setName(name);
		e1.setEmail(email);
		e1.setPassword(password);

		int status = stuDao.update1(e1);
		if (status > 0) {
			System.out.println("Record Updated Successfully");
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
