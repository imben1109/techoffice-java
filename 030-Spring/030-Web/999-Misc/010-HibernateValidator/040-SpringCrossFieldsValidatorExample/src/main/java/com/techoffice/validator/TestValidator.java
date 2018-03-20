package com.techoffice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.techoffice.validator.annoation.Test;

public class TestValidator implements ConstraintValidator<Test, Object>{

	private String field1;
	private String field2;
	
	public TestValidator(){
		System.out.println("Created");
	}
	
	@Override
	public void initialize(Test test) {
		this.field1 = test.field1();
		this.field2 = test.field2();
	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		return true;
	}

}
