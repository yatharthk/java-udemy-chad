package com.yk.demo;

import com.yk.jdbc.entity.Course;
import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
	
	public static void main(String[] args) {
		
	
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session =factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			int theId=1;
			
			//get the instructor from db
			Instructor instructor= session.get(Instructor.class, theId);
			
			//create some courses
			Course tempCourse= new Course("Air-Guitar Masterclass");
			Course tempCourse2= new Course("The pinball Masterclass");
			
			//add courses to the instructor
			instructor.add(tempCourse);
			instructor.add(tempCourse2);
			
			//save the instructor
			session.save(tempCourse);
			session.save(tempCourse2);
			
			//commit the  transaction
			session.getTransaction().commit();
			
			
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
