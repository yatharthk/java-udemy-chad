package com.yk.demo;

import com.yk.jdbc.entity.Course;
import com.yk.jdbc.entity.Instructor;
import com.yk.jdbc.entity.InstructorDetail;
import com.yk.jdbc.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
	
	public static void main(String[] args) {
		
	
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session =factory.getCurrentSession();

		try {
			session.beginTransaction();

			//create a course
			Course course= new Course("Pacman-How to Score One Million Points");

			//add reviews
			course.addReview(new Review("Great course .. Loved it!!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("A must course to start off"));
			//save the course ... and leverage the cascade all

			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());

			session.save(course);


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
