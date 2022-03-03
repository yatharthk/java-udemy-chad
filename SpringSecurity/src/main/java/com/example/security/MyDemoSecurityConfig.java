package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class MyDemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(userBuilder.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(userBuilder.username("mary").password("test123").roles("ADMIN"))
		.withUser(userBuilder.username("jane").password("test123").roles("MANAGER"));
	}
	
	
	

}
