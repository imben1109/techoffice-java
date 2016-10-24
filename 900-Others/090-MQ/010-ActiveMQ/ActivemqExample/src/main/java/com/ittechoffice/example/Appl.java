package com.ittechoffice.example;

public class Appl {
	public static void main(String[] args){
		Thread t1 = new Thread(new Consumer());
		Thread t2 = new Thread(new Producer());
		t1.start();
		t2.start();
	}
}
