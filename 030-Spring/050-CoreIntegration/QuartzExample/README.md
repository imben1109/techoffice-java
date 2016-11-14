# Spring Quartz Integration Example 

## Prerequisite
* Maven 3
* Eclipse Mars.1 Release (4.5.1)

## Dependencies
* Spring 4.3
* Quartz 2.2

## Example 

## Quartz Integration

Quartz define two components for job execution.
* Job: What would be executed
* Trigger: When would be executer

Spring provide various class for integrating quartz.

### Job
Spring provide the following class to create Quartz Job.
* JobDetailFactoryBean
* MethodInvokingJobDetailFactoryBean

Trigger
* SimpleTriggerFactoryBean
* CronTriggerFactoryBean

Scheduelr 
* SchedulerFactoryBean

```
<!-- Define Jobs -->
<bean name="simpleJobDetail" class="org.springframework.scheduling.quartz.JobDetailFactoryBean">
	<property name="jobClass" value="com.techoffice.example.job.SimpleJob"/>
</bean>

<bean id="methodInvokingJobDetail" class="org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean">
	<property name="targetObject" ref="methodInvokingJob"/>
	<property name="targetMethod" value="jobMethod"/>
	<property name="concurrent" value="false"/>
</bean>

<bean id="methodInvokingJob" class="com.techoffice.example.job.MethodInvokingJob"/>

<!-- Define Triggers -->
<bean id="simpleTrigger" class="org.springframework.scheduling.quartz.SimpleTriggerFactoryBean">
	<property name="jobDetail" ref="simpleJobDetail"/>
	<!-- Time of Start delay in ms -->
	<property name="startDelay" value="1000"/>
	<!-- Repeat Interval in ms -->
	<property name="repeatInterval" value="5000"/>
</bean>
<bean id="cronTrigger" class="org.springframework.scheduling.quartz.CronTriggerFactoryBean">
    <property name="jobDetail" ref="methodInvokingJobDetail"/>
    <!-- Corn Expression. Specified the Schedule -->
    <!-- Trigger 16:00 pm every day -->
    <property name="cronExpression" value="0 0 16 * * ?"/>
</bean>

<!-- Define the scheduler -->
<bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
    <property name="triggers">
        <list>
            <ref bean="cronTrigger"/>
            <ref bean="simpleTrigger"/>
        </list>
    </property>
</bean>
```

