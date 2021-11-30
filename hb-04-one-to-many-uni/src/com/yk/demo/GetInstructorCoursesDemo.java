package com.yk.demo;

import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Course;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session =factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			int theId=1;
			
			//get the instructor from db
			Instructor instructor= session.get(Instructor.class, theId);
			
			//print the instructor
			System.out.println("Instructor "+instructor);
			
			//get courses for the instructor
			System.out.println("courses:"+instructor.getCourses());
			
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
