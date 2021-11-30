package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;

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
		
		Instructor tempInstructor= new Instructor("Chad","Darby","www.luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail("Luv 2 code ","Guitar!!");
		tempInstructor.setInstructorDetail(instructorDetail);
		
		

		
		
		//start the session
		session.beginTransaction();
		int theId=9;

		session.save(tempInstructor);

		//get the instructorDetail Object
		InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
		
		//print the instructor Detail
		System.out.println("Instructor detail object"+ tempInstructorDetail);
		
		//printing the instructor object as there is a mapping between instructor detail to instructor set-up
//		using mapped by and cascade all is also set so all the operations we do in instructor_detail will pass in/ cascade to instructor object
		System.out.println("Printing associated instructor"+ tempInstructorDetail.getInstructor());
		
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("DONE!");
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		//handle the connection leak issue
		session.close();
		
		factory.close();
	}
		
	}

}
