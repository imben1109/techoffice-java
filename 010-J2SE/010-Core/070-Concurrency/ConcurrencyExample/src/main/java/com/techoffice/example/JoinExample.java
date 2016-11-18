package com.ittechoffice.example;

/**
 * function join() allow a thread to wait a specified time for another to complete
 * In this example, it would create two threads, Thread A and Thread B. 
 * Thread A would sleep 1s. Thread B would wait Thread A for completion and then do the remaining tasks.
 * 
 * @author imben1109
 *
 */
public class JoinExample {
	
	public static void main(String[] args){
		
		final Thread threadA = new Thread(new Runnable(){
			public void run(){
				System.out.println("This is Thread A part 1");
				System.out.println("Thread A is going to sleep");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("This is Thread A part 2");
			}
		});
		final Thread threadB = new Thread(new Runnable(){
			public void run(){
				System.out.println("This is Thread B part 1");
				System.out.println("Thread B is waiting Thread A for completion");
				try {
					threadA.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("This is Thread B part 2");
			}
		});
		
		threadA.start();
		threadB.start();
	}


}
