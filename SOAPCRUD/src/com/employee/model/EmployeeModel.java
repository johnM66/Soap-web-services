package com.employee.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employeeservice", namespace = "https://manas.com")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee")
public class EmployeeModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlElement(required = true)
	private int empID;
	@XmlElement(required = true)
	private String fistname;
	@XmlElement(required = true)
	private String lastname;
	@XmlElement(required = true)
	private String dob;
	@XmlElement(required = true)
	private String gender;
	@XmlElement(required = true)
	private String hireDate;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFistname() {
		return fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

}
