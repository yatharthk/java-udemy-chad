package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;
import com.yk.jdbc.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		//create the objects
		Instructor tempInstructor= new Instructor("Madhu","Patel","madhu@luv2code.com");
		InstructorDetail tempInstructorDetail= new InstructorDetail("http://www.luv2code.com/youtube","Guitar");
		
		//associate the objects \
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		//start the session
		session.beginTransaction();
		
		System.out.println("Saving the instructor" +tempInstructor);
		//save the session
		session.save(tempInstructor);// this will save both the objects as Cascade type is set.
		
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("DONE!");
		
		
		
	}
	finally {
		session.close();
		factory.close();
	}
		
	}

}
