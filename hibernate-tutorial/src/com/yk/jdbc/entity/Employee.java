package com.yk.jdbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	//not working for generation type=auto as it expects a dialect  in hibernate.config.xml file
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	public int getId() {
		return id;
	}

	@Column(name="company")
	private String company;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ "]";
	}
	
	
	
	
	
}
