package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.entity.Employee;

public class EmployeeDao {

	private Connection conn;

	public EmployeeDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerEmployee(Employee employee) {

		boolean f = false;

		try {
			String sql = "insert into employee(fname,email,password) values(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, employee.getFname());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;

	}

	public Employee loginEmployee(String em, String psw) {
		Employee employee = null;

		try {

			String sql = "select * from employee where email=? and password=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setEmail(rs.getString(2));
				employee.setPassword(rs.getString(3));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return employee;
	}

	public Employee getStudentById(int id) {

		Employee employee = null;

		try {

			String sql = "select * from employee where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setFname(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setPassword(rs.getString(4));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return employee;

	}

}
