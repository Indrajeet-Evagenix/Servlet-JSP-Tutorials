
package com.app;

import java.util.*;
import java.sql.*;

public class stuDao {

	public static Connection getConnection() {
		Connection con1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jisa_training", "root", "root");
			System.out.println("Connection Established");
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return con1;
	}

	public static int save(Stu e1) {
		int status = 0;
		try {
			Connection con1 = stuDao.getConnection();
			PreparedStatement ps1 = con1.prepareStatement("insert into student(fname,email,password) values (?,?,?)");

			ps1.setString(1, e1.getName());
			ps1.setString(2, e1.getEmail());
			ps1.setString(3, e1.getPassword());

			status = ps1.executeUpdate();

			con1.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}

		return status;
	}

	public static int update1(Stu e1) {
		int status = 0;
		try {
			Connection con1 = stuDao.getConnection();
			PreparedStatement ps1 = con1.prepareStatement("update student set fname=?,email=?,password=? where id=?");

			ps1.setString(1, e1.getName());
			ps1.setString(2, e1.getEmail());
			ps1.setString(3, e1.getPassword());
			ps1.setInt(4, e1.getId());

			status = ps1.executeUpdate();

			con1.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}

		return status;
	}

	public static int delete1(int id1) {
		int status = 0;
		try {
			Connection con1 = stuDao.getConnection();
			PreparedStatement ps1 = con1.prepareStatement("delete from student where id=?");
			ps1.setInt(1, id1);
			status = ps1.executeUpdate();

			con1.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return status;
	}

	public static Stu getStudentById(int id1) {
		Stu e1 = new Stu();

		try {
			Connection con1 = stuDao.getConnection();
			PreparedStatement ps1 = con1.prepareStatement("select * from student where id=?");
			ps1.setInt(1, id1);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {

				e1.setName(rs1.getString(1));
				e1.setEmail(rs1.getString(2));
				e1.setPassword(rs1.getString(3));

			}
			con1.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}

		return e1;
	}

	public static List<Stu> getAllStudent() {
		List<Stu> list = new ArrayList<Stu>();

		try {
			Connection con1 = stuDao.getConnection();
			PreparedStatement ps1 = con1.prepareStatement("select * from student");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Stu e1 = new Stu();
				e1.setName(rs1.getString(1));
				e1.setEmail(rs1.getString(2));
				e1.setPassword(rs1.getString(3));

				list.add(e1);
			}
			con1.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return list;
	}
}
