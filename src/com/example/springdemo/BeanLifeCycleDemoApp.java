package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	
	public static void main(String[] args) {
	
		//Load the spring configuration file.
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanLifeCycle-appContext.xml");
		
		//retrieve beans from container
		Coach thecoach= context.getBean("myCoach",Coach.class);
		
//		Print out the results
		System.out.println(thecoach.getDailyWorkout());
		
		context.close();
}
}
