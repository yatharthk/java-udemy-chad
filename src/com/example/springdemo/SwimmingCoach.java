package com.example.springdemo;

public class SwimmingCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimmingCoach(FortuneService theFortuneService) {
		this.fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 100m as warmup";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getDailyFortune();
	}

}
