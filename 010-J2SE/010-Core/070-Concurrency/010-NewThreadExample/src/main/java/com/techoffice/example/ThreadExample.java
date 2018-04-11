package com.techoffice.example;

public class ThreadExample {
	
	public static void main(String[] args){
		
		final Thread threadA = new Thread(new Runnable(){
			public void run(){
				System.out.println("This is Thread A part 1");
				System.out.println("Thread A is going to sleep");
				System.out.println("This is Thread A part 2");
			}
		});
		final Thread threadB = new Thread(new Runnable(){
			public void run(){
				System.out.println("This is Thread B part 1");
				System.out.println("Thread B is waiting Thread A for completion");
				System.out.println("This is Thread B part 2");
			}
		});
		
		threadA.start();
		threadB.start();
	}


}
