package com.example.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		// TODO Auto-generated method stub
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result = false;

		if (theCode != null) {
			for (String tempPrefix : coursePrefix) {
				System.out.print("tEMPpREFIX " + tempPrefix);
//				for (String theCode1 : theCode.split(",")) {
					result = theCode.startsWith(tempPrefix);
//					System.out.print("cODE:" + theCode1);
					
//					System.out.print(result);
//					System.out.println();
					if(result) break;
					
			}
		} else {
			result = false;
		}

		return result;

	}
}
