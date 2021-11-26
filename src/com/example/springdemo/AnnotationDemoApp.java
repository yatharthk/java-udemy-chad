package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("appContext.xml");
		
		//get bean from context
		Coach theCoach= context.getBean("tennisCoach",Coach.class);
		
		//call the method
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}
	
}
