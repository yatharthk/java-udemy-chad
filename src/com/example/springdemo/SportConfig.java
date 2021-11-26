package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	

	public static void main(String[] args) {
		//read spring configuration file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from context
		Coach theCoach= context.getBean("tennisCoach",Coach.class);
		
		//call the method
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
