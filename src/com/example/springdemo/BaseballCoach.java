package com.example.springdemo;

public class BaseballCoach implements Coach {

	//define a private field for the dependency
	private  FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getFortune();
	}
	
}
