package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Course;
import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;

public class DeleteInstructorDetailsDemo {
 
	public static void main(String[] args) {
		
		//create Session factory 
		SessionFactory factory= new Configuration()
								.configure("resources/hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//get the course
			int id=10;
			Course tempCourse= session.get(Course.class,id);
			
			//delete the course
			System.out.println("Deleting the course "+tempCourse);
			
			session.delete(tempCourse);
			
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
