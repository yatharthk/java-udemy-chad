package com.yk.demo;

import com.yk.jdbc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
	
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

			//create a course
			Course course= new Course("Pacman-How to Score One Million Points");

			//save the course
			System.out.println("Saving the course ...");
			session.save(course);
			System.out.println("Saved the course"+course);


			//create the students
			Student s1 = new Student("a","k","ak@gmail.com");
			Student s2 = new Student("c","k","ck@gmail.com");
			Student s3 = new Student("marry","public","marry@luv2code.com");

			//add course to students
			course.addStudent(s1);
			course.addStudent(s2);
			course.addStudent(s3);

			//save the students
			System.out.println("Saving students");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			System.out.println("Saved students: " +course.getStudents());


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
