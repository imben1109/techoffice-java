# Spring Task Executor Example 

## Prerequisite
* Maven 3
* Eclipse Mars.1 Release (4.5.1)

## Dependencies
* Spring 4.3

## Spring Task Executor

Spring provide many implement to TaskExecutor to control various aspects such as thread pools size.

## Example 

In this example, it declares a bean of ThreadPoolTaskExecutor which has only one thread pool.

```
<bean id="taskExecutor" class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
	<property name="corePoolSize" value="1" />
	<property name="maxPoolSize" value="1" />
	<property name="queueCapacity" value="1" />
</bean>
```