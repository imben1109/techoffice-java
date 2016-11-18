package com.ittechoffice.example;

/**
 * A instance variable could be altered by different thread.
 * In this example, It creates a instance of MemoryConsistentExample having a variable of count.
 * There are two thread would would get a value of count for processing and update the count.
 * Also, the thread would sleep for a not fixed time. 
 * The value of count would be altered by other thread. 
 * It make the value of expected value does not match the current value of count.
 * This is the problem of Memory Consistent. 
 * In order to solve the issue, synchronized statement or synchronized method should be used.
 * 
 * @author imben1109
 *
 */
public class MemoryConsistentExample {
	private int count = 0;

	public class SimpleCountTask implements Runnable{
		private MemoryConsistentExample memoryConsistentExample;
		
		public void setMemoryConsistentExample(MemoryConsistentExample memoryConsistentExample){
			this.memoryConsistentExample = memoryConsistentExample;
		}
		
		public void run(){
			for (int i=0; i<100; i++){
				int count = memoryConsistentExample.getCount();
				count++;
				memoryConsistentExample.increment();	
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (memoryConsistentExample.getCount() != count){
					System.out.println("The count is alter by other thread. Expected Count is " + count + ". But current count is " + memoryConsistentExample.getCount() );
				}
			}
		}
	}
	
	public MemoryConsistentExample(){
		SimpleCountTask simpleCountTaskA = new SimpleCountTask();
		simpleCountTaskA.setMemoryConsistentExample(this);
		SimpleCountTask simpleCountTaskB = new SimpleCountTask();
		simpleCountTaskB.setMemoryConsistentExample(this);
		Thread threadA = new Thread(simpleCountTaskA);
		Thread threadB = new Thread(simpleCountTaskB);
		threadA.start();
		threadB.start();
		System.out.println(count);
	}
	
	public void increment(){
		count++;
	}
	
	public int getCount(){
		return count;
	}
	
	public static void main(String[] args){
		new MemoryConsistentExample();
	}
}
