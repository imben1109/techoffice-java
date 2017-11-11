package com.techoffice.example;

public class Example {
	
	public static Example example = new Example();
	
	public static void main(String[] args){
		
		final Thread t1 = new Thread(new Runnable(){

			public void run() {
				System.out.println("Thread 1 start running");
				try {
					synchronized(example){
						example.wait();
					}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println("Thread 1 end running");
			}
		});
		
		Thread t2 = new Thread(new Runnable(){

			public void run() {
				System.out.println("Thread 2 start running");
				synchronized(example){
					example.notifyAll();
				}
				System.out.println("Thread 2 end running");
			}
		});

				
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		t2.start();

	}
}
