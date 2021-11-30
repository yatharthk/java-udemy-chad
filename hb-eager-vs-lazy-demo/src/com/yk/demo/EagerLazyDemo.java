package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Course;
import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;

public class EagerLazyDemo {

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
			System.out.println("DEMO Instructor "+instructor);


			System.out.println("DEMO Courses:"+instructor.getCourses());
			

			
			//commit the  transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("DEMO: The session is now closed");
			//get courses for the instructor
			System.out.println("DEMO Courses:"+instructor.getCourses());
			
			System.out.println("DEMO: Done!");
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
