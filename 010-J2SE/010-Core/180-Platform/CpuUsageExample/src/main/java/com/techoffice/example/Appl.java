package com.techoffice.example;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.techoffice.example.monitor.CpuMonitor;

public class Appl  {
	
	public static void main(String[] args) throws InterruptedException{
		final ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
		final Thread cpuMonitorThread = new Thread(new CpuMonitor(), "CpuMonitorThread");
		
		Thread t = new Thread(new Runnable(){
			public void run(){
				for (int i=0 ; i<100000; i++){
					new Thread(new Runnable(){
						public void run(){
							hashMap.put(UUID.randomUUID().toString(), "");
						}
					}).start();
				}
				cpuMonitorThread.interrupt();
			}
		});
		
		cpuMonitorThread.start();
		t.start();
		cpuMonitorThread.join();
		t.join();
	}
	
}
