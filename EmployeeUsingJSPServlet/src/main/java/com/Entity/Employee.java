package com.Entity;

import java.util.Date;

public class Employee {

	private int employeId;
	private String name;
	private String address;
	private byte gender;
	private double salary;
	private Date birthDate;

	public int getEmployeId() {
		return employeId;
	}

	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Employee(String name, String address, byte gender, double salary, Date birthDate) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public Employee(int employeId, String name, String address, byte gender, double salary, Date birthDate) {
		super();
		this.employeId = employeId;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
