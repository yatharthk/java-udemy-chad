package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	
//	@Autowired
	private FortuneService fortuneService;
	
	@Autowired
	public FootballCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
		this.fortuneService=fortuneService;
		}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "streach out your legs and practice ball control";
	}

	@Override
	public String getDailyFortune() {
		
		return this.fortuneService.getDailyFortune();
	}


}
