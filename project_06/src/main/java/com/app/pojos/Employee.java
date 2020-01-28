package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	private Integer employeeId;
	private String employeeName;
	private UserType role;
	private long employeePhoneNumber;
	private String employeeEmail;
	private String employeePassword,emplopyeeNewPassword;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeName, UserType role, long employeePhoneNumber, String employeeEmail,
			String employeePassword) {
		super();
		this.employeeName = employeeName;
		this.role = role;
		this.employeePhoneNumber = employeePhoneNumber;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "emp_name")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "emp_role")
	public UserType getRole() {
		return role;
	}
	public void setRole(UserType role) {
		this.role = role;
	}
	@Column(name = "emp_phnumber")
	public long getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}
	public void setEmployeePhoneNumber(long employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}
	@Column(name = "emp_email")
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	@Column(name = "emp_password")
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Transient
	public String getEmplopyeeNewPassword() {
		return emplopyeeNewPassword;
	}
	public void setEmplopyeeNewPassword(String emplopyeeNewPassword) {
		this.emplopyeeNewPassword = emplopyeeNewPassword;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", role=" + role
				+ ", employeePhoneNumber=" + employeePhoneNumber + ", employeeEmail=" + employeeEmail
				+ ", employeePassword=" + employeePassword + ", emplopyeeNewPassword=" + emplopyeeNewPassword + "]";
	}
	
	
}
