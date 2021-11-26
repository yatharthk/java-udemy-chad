package com.yk.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="instructor")
public class Instructor {
	
	//annotate the class with  entity and map to db table
	
		//define the fields
	//annotate the fields with db column names
	
	//set up mapping between instructor and instructor detail
		//create constructors
	//generate toString() method
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name="first_name")
	private String firtName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH })
	private List<Course> courses;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;


	public void setId(int id) {
		this.id = id;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Instructor(String firtName, String lastName, String email) {
		super();
		this.firtName = firtName;
		this.lastName = lastName;
		this.email = email;
	}


	public String getFirtName() {
		return firtName;
	}


	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firtName=" + firtName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}	
	
	
	//add convenience method for bi-directional relationship
	public void add(Course tempCourse) {
		if(courses==null) {
			courses= new ArrayList<>();
		}
		
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
	
	
	
}
