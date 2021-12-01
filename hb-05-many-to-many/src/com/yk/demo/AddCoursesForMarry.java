package com.yk.demo;

import com.yk.jdbc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMarry {
	
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
			int studentId=6;
			Student student1= session.get(Student.class,studentId);

			System.out.println("Loaded the student"+student1);
			System.out.println("Courses:" +student1.getCourses());

//			create more courses
			Course course= new Course("Rubik's Cube-How to speed Cube");
			Course course2= new Course("Atari 2600- Game development");

//			add student to courses
			student1.addCourse(course);
			student1.addCourse(course2);

			//save the courses
			System.out.println("Saving the courses");
			session.save(course);
			session.save(course2);

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
