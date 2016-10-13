package com.ittechoffice.example;

public class Task implements Runnable{

	public void run() {
		System.out.println("This task is starting to run");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("This task completed");
	}
	

}
