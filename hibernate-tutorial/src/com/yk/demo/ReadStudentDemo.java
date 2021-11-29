package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

import java.text.ParseException;
import java.util.Date;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		//create a student object
		Date date= DateUtils.parseDate("24/05/1998");
		System.out.println("Creating  new student object");
		Student theStudent=new Student("m","k",date,"mk@gmail.com");
		
		//start the transaction
		session.beginTransaction();
		
		//save the student object
		System.out.println("Saving student");
		
		session.save(theStudent);
		//commit the transaction;
//		session.getTransaction().commit();
		
		System.out.println("Saved student: Generated id: "+theStudent.getId());
	
		
//		session=factory.getCurrentSession();
//		session.beginTransaction();
		
		//retrieve the object entered using student id auto-generated
		Student newStudent= session.get(Student.class, theStudent.getId());
		
		System.out.println("NEW Student retrieved is "+newStudent);
		
		System.out.println("Done");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		session.flush();
		session.close();
		factory.close();
	}
		
	}

}
