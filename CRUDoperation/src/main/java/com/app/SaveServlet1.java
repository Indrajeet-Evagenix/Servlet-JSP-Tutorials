
package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet1")
public class SaveServlet1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Stu e1 = new Stu();
		e1.setName(name);
		e1.setEmail(email);
		e1.setPassword(password);

		int status = stuDao.save(e1);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("student.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
