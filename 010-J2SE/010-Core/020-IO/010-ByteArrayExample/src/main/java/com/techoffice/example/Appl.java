package com.techoffice.example;

public class Appl {
	
	public static void main(String[] args){
		byte[] a = "testing".getBytes();
		System.out.println("Print byte array: " + a);
		String aStr = new String(a);
		System.out.println("Print string convert by new String(byte array): " + aStr);
	}
	
}
