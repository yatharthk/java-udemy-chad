package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

public class PrimaryKeyDemo {

		
		public static void main(String[] args) {
			// create Session Facctory object
			SessionFactory factory= new Configuration()
					.configure("resources/hibernate.cfg.xml")
					.addAnnotatedClass(Student.class).buildSessionFactory();
			
			
			//create session
			Session session =  factory.getCurrentSession();
		
		try {
			
			//create 3 student object
			System.out.println("Creating 3 new students object");
			Student theStudent=new Student("s","k","sk@gmail.com");
			Student theStudent2=new Student("n","k","nk@gmail.com");
			Student theStudent3=new Student("a","k","ak@gmail.com");
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving students");
			session.save(theStudent);
			session.save(theStudent2);
			session.save(theStudent3);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		
		}

	

}
