package com.example.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

//	private String data[]= {
//			"Beware of the wolf in the sheep's clothing",
//			"Diligence  is the mother of good luck",
//			"The jourrney is the reward"
//			
//	};
	
	@Value("${fortunes}")
	private String data[];
	private Random myRandom= new Random();
	@Override
	public String getDailyFortune() {
		int index=myRandom.nextInt(data.length);
		return data[index];
	}

}
