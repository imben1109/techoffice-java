package com.techoffice.example.monitor;

import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServerConnection;

import com.sun.management.OperatingSystemMXBean;

public class CpuMonitor implements Runnable {
	
	public void run() {
        while(!Thread.interrupted()){
        	try {
	        	MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();
	    		OperatingSystemMXBean osMBean = ManagementFactory.newPlatformMXBeanProxy(
	        			mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
    			double cpuLoad = osMBean.getProcessCpuLoad();	
    			System.out.println("CPU Usage: " + cpuLoad);
    			try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
	}
	
}
