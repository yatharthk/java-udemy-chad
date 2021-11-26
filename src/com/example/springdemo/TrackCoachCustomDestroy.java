package com.example.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoachCustomDestroy implements Coach,DisposableBean {

	private FortuneService fortuneService;
	
	public TrackCoachCustomDestroy( FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		System.out.println("constructor");
	}
	
	public void doMyStartupStuff() {
		System.out.println("initializing bean");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Sprint run 100m";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "You will ace today.";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TrackCoachCustom: Ready to stop this session."
				+ "/n(No neeed to declare this method in xml (<destroy-method> not required.");
		
	}

}
