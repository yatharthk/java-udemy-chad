package com.example.springdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load(the config file)
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("appContext.xml");
		
		//get the beans
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
				
		//compare Bean objets
		boolean result=(theCoach==alphaCoach);
		
		System.out.println("Pointing to the same object: "+result);
		
		System.out.println("Memory location for theCoach" +theCoach);
		
		System.out.println("Memory location for alphaCoach"+alphaCoach);
		
		context.close();
	}
}
