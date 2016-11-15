package com.ittechoffice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class Appl {
	
	@Autowired
	private TaskExecutor taskExecutor; 
	
	public void run(){
		System.out.println("Spring Task Executor Example");
		taskExecutor.execute(new Task());
		taskExecutor.execute(new Task());
		taskExecutor.execute(new Task());
		taskExecutor.execute(new Task());
		taskExecutor.execute(new Task());
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
