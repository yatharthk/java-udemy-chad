package com.yk.demo;

import com.yk.jdbc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteACourseDemo {
	
	public static void main(String[] args) {
		
	
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session =factory.getCurrentSession();

		try {
			session.beginTransaction();

// get pacman course from db using course id
			int courseId=11;
			Course course= session.get(Course.class,courseId);

			//delete the course
			System.out.println("Deleting the course"+course);
			session.delete(course);
			System.out.println("Deleted course"+course);


			//commit the  transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			
			factory.close();
		}
}
}
