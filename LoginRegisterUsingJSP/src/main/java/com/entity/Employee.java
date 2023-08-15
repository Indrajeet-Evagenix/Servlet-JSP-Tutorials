package com.entity;

public class Employee {

	private int id;
	private String fname;
	private String email;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public Employee(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(String fname, String email, String password) {
		super();
		this.fname = fname;
		this.email = email;
		this.password = password;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", email=" + email + ", password=" + password + "]";
	}

}
