package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;

public class DeleteInstructorDetailsDemo {

	public static void main(String[] args) {
		
		//create Session factory 
		SessionFactory factory= new Configuration()
								.configure("resources/hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId=9;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,theId);
		
			System.out.println("tempInstructorDetail"+ tempInstructorDetail);
			System.out.println("the associated Instructor "+tempInstructorDetail.getInstructor());
			System.out.println("Deleting the object");
			//now to remove the associated Instructor form InstructorDetail set the object reference to null
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			//IF NOT DONE Hibernate will throw error saying the object you are trying to delete
			// will be re-saved as it has a dependency.(i.e. InstructorDetail still has id(FK) pointing to Instructor)
			
			session.delete(tempInstructorDetail);
			System.out.println("Done");
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
}
