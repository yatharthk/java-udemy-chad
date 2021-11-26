package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimmingJavaConfigDemoApp {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfigNoXml.class);
		
		Coach theCoach= context.getBean("swimmingCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		context.close();

	}

}
