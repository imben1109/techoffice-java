package com.techoffice.example;

public class ThreadLocalUtils {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static void setValue(String value){
		threadLocal.set(value);
	}
	
	public static String get(){
		return threadLocal.get();
	}
}
