package com.techoffice.validator.annoation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.techoffice.validator.TestValidator;

@Documented
@Constraint(validatedBy = TestValidator.class)
@Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

	String message() default "Fields values don't match!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String field1();
	String field2();

}
