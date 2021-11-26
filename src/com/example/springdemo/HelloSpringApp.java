package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

 public static void main(String[] args) {
	

		// Load spring configuration file
	ClassPathXmlApplicationContext applicationContext=
			new ClassPathXmlApplicationContext("appContext.xml");
		
		//retrive bean from spring container
	
	Coach theCoach= (Coach)applicationContext.getBean("myCoach",Coach.class);
		//call methods on bean
	
System.out.println(theCoach.getDailyWorkout());

//let's call our new method to get fortunes.
System.out.println(theCoach.getDailyFortune());
		//close the context
applicationContext.close();

 }
 }
