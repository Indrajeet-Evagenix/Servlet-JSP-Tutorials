package com.EmployeeDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Employee;

public class EmployeeDao {

	private Connection conn;

	public EmployeeDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerEmployee(Employee employee) {

		boolean f = false;

		try {
			String sql = "insert into employee(name,address,gender,salary,birthdate) values(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setInt(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, (Date) employee.getBirthDate());
			
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;

	}
	
	public boolean updateEmployee(Employee employee) {

		boolean f = false;

		try {
			String sql = "update employee set name=?,address=?,gender=?,salary=?,birthdate=? where employeeid=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setInt(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, (Date) employee.getBirthDate());

			ps.setInt(6, employee.getEmployeId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;

	}

	public boolean deleteEmployee(int id) {

		boolean f = false;

		try {
			String sql = "delete from employee where employeeid=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;

	}

	public List<Employee> getAllEmployee() {

		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;

		try {

			String sql = "select * from employee";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setGender((byte) rs.getInt(4));
				employee.setSalary(rs.getDouble(5));
				employee.setBirthDate(rs.getDate(6));
				list.add(employee);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Employee getEmployeeById(int id) {

		Employee employee = null;

		try {

			String sql = "select * from employee where employeeid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setGender((byte) rs.getInt(4));
				employee.setSalary(rs.getDouble(5));
				employee.setBirthDate(rs.getDate(6));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return employee;

	}

}
