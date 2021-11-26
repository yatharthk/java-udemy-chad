package com.example.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	//default constructor
	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//this constructor is used for constructor injection
public TrackCoach(  FortuneService theFortuneService) {
	this.fortuneService=theFortuneService;
}
	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it";
	}

	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside nethod doMySTartUpStuff");
	}
	
	
	//add an destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");
	}
}
