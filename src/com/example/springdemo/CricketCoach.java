package com.example.springdemo;

public class CricketCoach implements Coach {

	private String emailAddress;
	private String team;
	
	private FortuneService FortuneService;
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("setting email as "+emailAddress);
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("setting team name as"+team);
		
		this.team = team;
	}

	
	
	//create no arg  constructor
	public CricketCoach() {
	System.out.println("cricketCcoach: inside no-arg consturctor");
		// TODO Auto-generated constructor stub
	}
	
	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method -setFortuneService");
		FortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 mins.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.FortuneService.getFortune();
	}

}
