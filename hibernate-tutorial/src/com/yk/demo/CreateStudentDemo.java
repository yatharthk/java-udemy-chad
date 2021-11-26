package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		//create a student object
		System.out.println("Creating  new student object");
		Student theStudent=new Student("y","k","yk@gmail.com");
		
		//start the transaction
		session.beginTransaction();
		
		//save the student object
		System.out.println("Saving student");
		session.save(theStudent);
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
	finally {
		session.close();
		factory.close();
	}
		
	}

}
