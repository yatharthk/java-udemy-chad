package com.yk.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create Session Factory object
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session =  factory.getCurrentSession();
	
	try {
		
		int studentId=1;
		
		//start the session
		session.beginTransaction();
		
		System.out.println("Getting student with id :"+studentId);
		Student myStudent =session.get(Student.class,studentId);
		
		System.out.println("Deleting the Student:"+myStudent);
		
		// pass in the object to delete/delete the row
		session.delete(myStudent);
		
		//deleting student id 2
		System.out.println("Deleting student with id=2");
		session.createQuery("delete from Student where id=2").executeUpdate();
		
		
		//commit the change to database
		session.getTransaction().commit();
		
		System.out.println("Deleted!");
		
	}
	finally {
		session.close();
		factory.close();
	}
		
	}

}
