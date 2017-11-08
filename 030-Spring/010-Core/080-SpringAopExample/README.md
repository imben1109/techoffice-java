# Spring Aspect-Oriented Programming (AOP) Example
It is a programming paradigm which aims to increase modularity by separation of cross-cutting concerns.

## AOP Concepts
* Aspect		: This is a class that used to cut the point of concern
* Join Point	: This is a cutting point. That is where the method to be executed.
* Pointcut		: This is an expression for Joint Point Matching. 
* Advice		: This is an action token for the pointcut. It would be different point cut such before, around, after. 

## Spring AOP 

The AOP should be enabled in Spring XML Config
```
<aop:aspectj-autoproxy/>
```

```
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
```
