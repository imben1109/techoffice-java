# Spring Mockito Factory Bean Example

## Prerequisite
* Maven 3
* Eclipse Mars 4.5.1

## Dependencies
* Spring 4.3
* JUnit 4.12
* Mockito 2.0.111-beta

## Problem
There are two beans, SimpleSpringService depends on SimpleSpringBean. 
If I would like to mock SimpleSpringService for Spring test.

```
<bean id="simpleSpringService" class="org.mockito.Mockito" factory-method="mock">
	<constructor-arg value="com.ittechoffice.example.SimpleSpringService" />
</bean>
``` 
Exception would be thrown because Spring inferred method, it would autowire bean by type. Therefore, null pointer exception would be thrown.

## Solution
Reference: https://spring.io/blog/2012/11/07/spring-framework-3-2-rc1-new-testing-features/
Spring suggest an workaround solution which is MockitoFactoryBean. 
MockitoFactoryBean is just a Custom Spring Factory Bean to mock bean in Spring.

com.ittechoffice.example.mockito.MockitoFactoryBean.java
```
public class MockitoFactoryBean<T> implements FactoryBean<T> {

    private Class<T> classToBeMocked;
    
    public MockitoFactoryBean(Class<T> classToBeMocked) {
        this.classToBeMocked = classToBeMocked;
    }

	public T getObject() throws Exception {
		return Mockito.mock(classToBeMocked);
	}

	public Class<?> getObjectType() {
		return classToBeMocked;
	}

	public boolean isSingleton() {
		return true;
	}

}

```

```
<bean id="simpleSpringService" class="com.ittechoffice.example.mockito.MockitoFactoryBean" >
	<constructor-arg value="com.ittechoffice.example.SimpleSpringService" />
</bean>
```