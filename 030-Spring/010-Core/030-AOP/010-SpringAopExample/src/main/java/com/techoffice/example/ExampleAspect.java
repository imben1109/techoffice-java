package com.techoffice.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExampleAspect {
	
	@Pointcut("execution (* com.techoffice..*(..))")		
	public void anyRun() {}
	
	@Before(value="anyRun()")
	public void beforeAnyRun(JoinPoint jointPoint){
		System.out.println("Before " + jointPoint.getClass().getName() + "." + jointPoint.getSignature().getName());
	}
	
	@After(value="anyRun()")
	public void afterAnyRun(JoinPoint jointPoint){
		System.out.println("After " + jointPoint.getClass().getName() + "." + jointPoint.getSignature().getName());
	}
}
