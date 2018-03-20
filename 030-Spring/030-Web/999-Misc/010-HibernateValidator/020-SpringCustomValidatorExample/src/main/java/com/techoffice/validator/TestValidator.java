package com.techoffice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.techoffice.validator.annoation.Test;

public class TestValidator implements ConstraintValidator<Test, String>{

	@Override
	public void initialize(Test arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return false;
	}

}
