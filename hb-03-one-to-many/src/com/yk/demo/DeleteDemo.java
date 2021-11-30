package com.yk.demo;

import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		int theId=1;
		//start the session
		session.beginTransaction();
		
		//get the instructor using primary key
		Instructor tempInstructor= session.get(Instructor.class,theId);
		
		System.out.println("Deleting the instructor"+tempInstructor);
		
		//delete the instructor :Note: this will also delete the instructor details becasue of cascade type
		
		session.delete(tempInstructor);
		
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
