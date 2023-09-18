package entity;

import java.util.Date;

public class Employee {

	private int employeeId;
	private String name;
	private String address;
	private byte gender;
	private double salary;
	private Date birthDate;
	private byte[] skillMasterId;

	public Employee(String name, String address, byte gender, double salary, Date birthDate, byte[] skillMasterId) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
		this.birthDate = birthDate;
		this.skillMasterId = skillMasterId;
	}

	public byte[] getSkillMasterId() {
		return skillMasterId;
	}

	public void setSkillMasterId(byte[] skillMasterId) {
		this.skillMasterId = skillMasterId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + ", gender=" + gender
				+ ", salary=" + salary + ", birthDate=" + birthDate + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String name, String address, byte gender, double salary, Date birthDate,
			byte[] skillMasterId) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
		this.birthDate = birthDate;
		this.skillMasterId = skillMasterId;
	}

	public Employee(int employeeId, String name, String address, byte gender, double salary, Date birthDate) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
		this.birthDate = birthDate;
	}

}
