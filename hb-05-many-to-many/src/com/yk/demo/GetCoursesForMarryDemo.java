package com.yk.demo;

import com.yk.jdbc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMarryDemo {
	
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

//			get the student form db
			int studentId=4;
			Student student1= session.get(Student.class,studentId);

			System.out.println("Loaded the s"+student1);
			System.out.println("Courses:" +student1.getCourses());

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
