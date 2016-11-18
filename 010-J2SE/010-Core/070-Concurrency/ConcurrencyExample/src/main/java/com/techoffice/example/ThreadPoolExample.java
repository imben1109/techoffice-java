package com.ittechoffice.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Thread Creation require significant amount of memory.
 * In order to minimize the overhead due to thread creation, a pool of thread would be used.
 * The strategy is to use ExecutorService(Interface) to call Executor(Inteface) to launch new task.
 * Executors provide methods to create various Executor and ExecutorServces
 * e.g. newFixedThreadPool(n): it could create a specified number of thread pool 
 * 
 * The Runnable / Callable Object could pass to ExecutorService and then put in queue pending for execution.
 * if a Callable object is submit to ExecutorService, it would return a Future object. 
 * The future is what would be return in Callable method.
 * 
 * @author imben1109
 *
 */
public class ThreadPoolExample {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Callable<String> callA = new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Calling A");
				Thread.sleep(5000);
				return "Completed CallA";
			}
		};
		Callable<String> callB = new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Calling B");
				return "Completed CallB";
			}
		};
		Callable<String> callC = new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Calling C");
				return "Completed CallC";
			}
		};
		Future<String> futureA = executorService.submit(callA);
		Future<String> futureB = executorService.submit(callB);
		Future<String> futureC = executorService.submit(callC);
		
		// the get() method in Future would wait for completion of the process
		System.out.println(futureA.get());
	}
}
