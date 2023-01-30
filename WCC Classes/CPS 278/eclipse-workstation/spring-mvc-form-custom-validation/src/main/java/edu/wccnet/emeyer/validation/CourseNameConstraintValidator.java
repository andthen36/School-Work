package edu.wccnet.emeyer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseNameConstraintValidator implements ConstraintValidator<CourseName, String> {
	
	private String[] prefixCourseName;
	
	public void initialize(CourseName courseName) {
		prefixCourseName = courseName.value();
	}
	
	@Override
	public boolean isValid(String userInput, ConstraintValidatorContext context) {
		
		// TODO Auto-generated method stub
		boolean result;
		if (userInput != null) {
			for(String eachPrefix : prefixCourseName) {
				result = userInput.startsWith(eachPrefix);
				if(result = true) {
					return result;
				}
			}
			return false;
		}else {
			return true;
		}
	}

}
