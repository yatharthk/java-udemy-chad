package com.example.springmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)//class which defines necessary method
@Target({ElementType.METHOD,ElementType.FIELD})//where can be applied? method or field
@Retention(RetentionPolicy.RUNTIME)//how long will marked anotation be used? Retain the annotation in bytecode and use at runtime 
public @interface CourseCode {
	
	
	//define default course code
	public String[] value() default "LUV";
	
	//define default error message
	public String message() default "must start with LUV";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	

}
