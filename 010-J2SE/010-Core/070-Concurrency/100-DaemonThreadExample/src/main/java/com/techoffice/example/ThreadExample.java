package com.techoffice.example;

public class ThreadExample {
	
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
				System.out.println("This is Thread B");
			}
		});
		
		threadA.setDaemon(true);
		threadA.start();
		threadB.start();
	}


}
