package com.example.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach:Default constructor");
	}

	
	//define init method
	@PostConstruct
	public void doMmyStartupStuff() {
		System.out.println("TennisCoach:Inside of doMyStartUpStuff");
	}
	
	//define destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
			System.out.println("TennisCoach: Inside doMyCleanUpStuff");
	}
	
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">>TennisCoach:inside setFortuneService");
//		this.fortuneService=fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Pracice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getDailyFortune();
	}

}
