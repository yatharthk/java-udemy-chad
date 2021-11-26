package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	
	public static void main(String[] args) {
	
		//Load the spring configuration file.
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanScoped-appContext.xml");
		
		//retrieve beans from container
		Coach thecoach= context.getBean("myCoach",Coach.class);
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
//		check if results are same
		boolean result=(thecoach==alphaCoach);
//		Print out the results
		System.out.println("Pointing to the same object: "+result);
		System.out.println("Memory location of thecoach: "+thecoach);
		System.out.println("Memory location of alphaCoach: "+alphaCoach);
		
		context.close();
}
}
