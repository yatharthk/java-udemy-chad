package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPrototypeScopedDemoApp {

	
	public static void main(String[] args) {
	
		//Load the spring configuration file.
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("prototypeDestroynoConfig-appContext.xml");
		
		//retrieve beans from container
		Coach thecoach= context.getBean("myCoach",TrackCoachCustomDestroy.class);

		System.out.println(thecoach.getDailyWorkout());

		
		context.close();
}
}
