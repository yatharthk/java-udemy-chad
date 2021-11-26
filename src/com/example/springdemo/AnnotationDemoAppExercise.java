package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoAppExercise {

	public static void main(String[] args) {
		//read spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("appContext.xml");
		
		//get bean from context
		SwimCoach theCoach= (SwimCoach)context.getBean("swimCoach",Coach.class);
		
		//call the method
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeamName());
		
		//close the context
		context.close();
	}
	
}
