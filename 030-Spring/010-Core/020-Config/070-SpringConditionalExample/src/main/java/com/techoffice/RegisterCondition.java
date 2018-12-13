package com.techoffice;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class RegisterCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		metadata.getAllAnnotationAttributes(RegisterConditional.class.getName()).get("value");
		return false;
	}

}
