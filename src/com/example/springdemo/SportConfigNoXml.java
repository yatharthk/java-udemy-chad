package com.example.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages ="com.example.srpingdemo")
//Since we defined both the beans component scan is not required
public class SportConfigNoXml {
	
	//define bean for outr sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	//define bean for our SwimmingCoach and injece dependency

	@Bean
	public Coach swimmingCoach() {
		return new SwimmingCoach(sadFortuneService());
	}
}
