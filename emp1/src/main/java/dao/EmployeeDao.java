package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class EmployeeDao {

	private Connection conn;
	private int totalNoOfRecords;

	public EmployeeDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addEmployeeDetails(Employee employee) {
		boolean f = false;

		try {
			String sql = "insert into Employee_indra(name,address,gender,salary,birthdate) values(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setByte(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, (Date) employee.getBirthDate());
			int j = ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			int empId = 0;
			if (rs.next()) {
				empId = rs.getInt(1);
			}

			for (int i = 0; i < employee.getSkillMasterId().length; i++) {
				EmployeeSkillMasterDao dao = new EmployeeSkillMasterDao(conn);
				dao.addSkills(empId, employee.getSkillMasterId()[i]);
//				System.out.println(employee.getSkillMasterId()[i]);

			}

			if (j == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean updateEmployeeDetails(Employee employee) {
		boolean f = false;

		try {
			String sql = "update Employee_indra set name=?,address=?,gender=?,salary=?,birthdate=? where employeeId=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setByte(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, (Date) employee.getBirthDate());

			ps.setInt(6, employee.getEmployeeId());

			int j = ps.executeUpdate();

			if (j == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Employee> allEmployeeDetails() {
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;

		try {
			String sql = "select * from Employee_indra";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setGender((byte) rs.getInt(4));
				employee.setSalary(rs.getDouble(5));
				employee.setBirthDate(rs.getDate(6));
				list.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println(totalNoOfRecords);
		return list;
	}

	public int getNoOfRecords() {

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from Employee_indra");
			if (rs.next()) {
				this.totalNoOfRecords = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Total Number of Records: " + totalNoOfRecords);

		return this.totalNoOfRecords;

	}

	public Employee getEmployeeById(int id) {

		Employee employee = null;

		try {

			String sql = "select * from Employee_indra where employeeId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setGender((byte) rs.getInt(4));
				employee.setSalary(rs.getDouble(5));
				employee.setBirthDate(rs.getDate(6));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;

	}

	public boolean deleteEmployee(int id) {

		boolean f = false;

		try {
			String sql = "delete from Employee_indra where employeeId=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public List<Employee> viewAllEmployeePerPage(int page, int pagePerRecord) {
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;

		try {
			String sqlNew = "SELECT * FROM Employee_indra ORDER BY employeeId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			System.out.println(sqlNew);

			PreparedStatement ps = conn.prepareStatement(sqlNew);
			ps.setInt(1, (page - 1) * pagePerRecord);
			ps.setInt(2, pagePerRecord);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setGender((byte) rs.getInt(4));
				employee.setSalary(rs.getDouble(5));
				employee.setBirthDate(rs.getDate(6));
				list.add(employee);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Employees Details: " + list);

		return list;
	}

}
