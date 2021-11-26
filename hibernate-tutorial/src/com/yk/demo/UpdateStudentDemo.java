package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		
		int studentId=1;
		
		//find out the student's id :primary key
		System.out.println("\n Getting student with id: "+ studentId);
		
		session.beginTransaction();
		
		Student myStudent = session.get(Student.class, studentId);
		
		System.out.println("Get complete "+myStudent);
		
		System.out.println("Updating student");
		
		//statement is updating it in memory 
		myStudent.setFirstName("Scooby");
		myStudent.setLastName("Doo");
		
		//commit  the transaction
		session.getTransaction().commit();
		//after committing the new mail is saved to database
		session=factory.getCurrentSession();
		session.beginTransaction();
		
		
		//applying bulk update
		//updating email for all students
		//create Query 2. executeQuery
		session.createQuery("update Student set email='foo@.email.com'").executeUpdate();
	
		session.getTransaction().commit();
		
		System.out.println("Done");
		
		
		
		
	}
	finally {
//		session.flush();
//		session.close();
		factory.close();
	}
		
	}

}
