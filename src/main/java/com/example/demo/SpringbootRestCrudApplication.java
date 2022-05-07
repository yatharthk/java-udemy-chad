package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class SpringbootRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestCrudApplication.class, args);
	}

}
