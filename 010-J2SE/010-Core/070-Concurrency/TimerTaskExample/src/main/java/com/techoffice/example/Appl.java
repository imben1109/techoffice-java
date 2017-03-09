package com.techoffice.example;

import java.util.Timer;
import java.util.TimerTask;

/**
 * function join() allow a thread to wait a specified time for another to complete
 * In this example, it would create two threads, Thread A and Thread B. 
 * Thread A would sleep 1s. Thread B would wait Thread A for completion and then do the remaining tasks.
 * 
 * @author imben1109
 *
 */
public class Appl {
	
	public static void main(String[] args) throws InterruptedException{
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
            	System.out.println("Periodically Say Hi!");
            }
        }, 0, 1000);

        Thread.sleep(5000);
        timer.cancel();
        System.out.println("Timer is cancelled");
	}


}
