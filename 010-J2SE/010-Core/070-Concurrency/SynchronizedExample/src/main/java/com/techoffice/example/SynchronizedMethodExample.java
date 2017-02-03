package com.techoffice.example;


public class SynchronizedMethodExample {
	
	public void doSomething(){
		for (int i=0;i <10; i++){
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
	
	public static void main(String[] args){
		final SynchronizedMethodExample e = new SynchronizedMethodExample();
		for (int i=0;i <10; i++){
			Thread t1 = new Thread(new Runnable(){

				public void run() {
					e.doSomething();
				}
				
			});
			t1.start();
		}
				
	}
	
}
