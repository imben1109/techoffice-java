package com.techoffice.example;

public class JniCaller {
	static {
		System.loadLibrary("dll/JniCaller");
	}
	
	private native void print();
	
	public static void main(String[] args){
		(new JniCaller()).print();
	}
}
