package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

import java.text.ParseException;
import java.util.Date;

public class PrimaryKeyDemo {

		
		public static void main(String[] args) {
			// create Session Factory object
			SessionFactory factory= new Configuration()
					.configure("resources/hibernate.cfg.xml")
					.addAnnotatedClass(Student.class).buildSessionFactory();
			
			
			//create session
			Session session =  factory.getCurrentSession();
		
		try {
			
			//create 3 student object

			Date date1=DateUtils.parseDate("14/01/1996");
			Date date2=DateUtils.parseDate("31/01/1999");
			Date date3=DateUtils.parseDate("14/02/1997");

			System.out.println("Creating 3 new students object");
			Student theStudent=new Student("s","k",date1,"sk@gmail.com");
			Student theStudent2=new Student("n","k",date2,"nk@gmail.com");
			Student theStudent3=new Student("a","k",date3,"ak@gmail.com");
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		}

	

}
