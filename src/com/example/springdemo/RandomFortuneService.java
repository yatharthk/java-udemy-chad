 package com.example.springdemo;


import java.util.Random;

public class RandomFortuneService implements FortuneService{

	
	String fortunes[]= {"ITS YOUR LUCKY DAY","TIME FOR AN AWESOME TRAINING SESSION","HAPPY SPORTING"};
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		Random r= new Random();
		int randomNum=r.nextInt(3);
		return fortunes[randomNum];
	}
}
