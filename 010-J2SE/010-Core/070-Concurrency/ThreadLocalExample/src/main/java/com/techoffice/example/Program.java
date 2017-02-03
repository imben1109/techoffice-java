package com.techoffice.example;

/**
 * ThreadLocal provide a way to store variable with a Thread.
 * 
 * In most situations, Data Access Object and Service are singleton. 
 * For a Request-Response mechanism, It may need a information of Login User or others just within the thread. 
 * 
 * This is an example demonstrating ThreadLocal Example.
 * 
 * @author Ben_c
 *
 */
public class Program implements Runnable{

	public void run() {
		System.out.println(ThreadLocalUtils.get());
		ThreadLocalUtils.setValue(Thread.currentThread().getName());
		System.out.println(ThreadLocalUtils.get());
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new Program());
		Thread t2 = new Thread(new Program());
		t1.start();
		t1.join();
		t2.start();
		t2.join();
	}


}
