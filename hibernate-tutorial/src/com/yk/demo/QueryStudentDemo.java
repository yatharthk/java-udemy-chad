package com.yk.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		//start the transaction
		session.beginTransaction();
		
		//save the student object
		@SuppressWarnings("unchecked")
		//USE ENTITY NAME WHILE QUERYING . INSTEAD OF TABLE NAME AND fix :" " Not mapped Error
		List<Student> studentList=session.createQuery("from Student").getResultList();
		displayStudents(studentList);
		
		
		//query Students :lastnmae='Doe'
		studentList=session.createQuery("from Student s where s.email LIKE'%@gmail.com'").getResultList();
		
		//print the object
		System.out.println("Students with email as %gmail.com");
		displayStudents(studentList);
		
		
		//query Students :firstName=y OR lastName='k'
				studentList=session.createQuery("from Student s where s.firstName='y' OR s.lastName LIKE'%k'").getResultList();
				
				//print the object
				System.out.println("Students with  s.firstName='y' OR s.lastName LIKE'%k'");
				displayStudents(studentList);
		
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
	finally {
//		session.flush();
		session.close();
		factory.close();
	}
		
	}

	private static void displayStudents(List<Student> studentList) {
		studentList.forEach(System.out::println);
	}

}
