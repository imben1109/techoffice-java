package com.techoffice.example;


public class LockExample {
	
	public void doSomething1(){
		synchronized(this){
			for (int i =0; i < 10; i++){
				System.out.println(Thread.currentThread().getName() + ": doSomething1 " + i);
			}
		}
	}
	
	public void doSomething2(){
		synchronized(this){
			for (int i =0; i < 10; i++){
				System.out.println(Thread.currentThread().getName() + ": doSomething2 " + i);
			}	
		}
	}
	
	public static void main(String[] args){
		final NotLockExample e = new NotLockExample();
		for (int i=0;i <10; i++){
			
			Thread t1 = new Thread(new Runnable(){

				public void run() {
					long id = Thread.currentThread().getId();
					if (id%2 == 0){
						e.doSomething1();
					}else{
						e.doSomething2();
					}
				}
				
			});
			t1.start();
		}
				
	}
	
}
