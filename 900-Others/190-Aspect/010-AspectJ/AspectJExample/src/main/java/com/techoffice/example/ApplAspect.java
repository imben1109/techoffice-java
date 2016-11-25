package com.techoffice.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ApplAspect {

	@Pointcut("execution(* com.techoffice.example..*(..))")	
	public void run() {}
	
	@Before("run()")
	public void before(JoinPoint joinPoint){
		System.out.println("Before " + joinPoint.getClass().getName() + "." + joinPoint.getSignature().getName());
		
	}
}
