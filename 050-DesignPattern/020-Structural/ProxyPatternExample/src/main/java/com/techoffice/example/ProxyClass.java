package com.techoffice.example;

/**
 * Proxy is an intermediary between client and the class. 
 * It can add functionality to the proxy in additon to the functionality provided in the class.
 * Also, the funcationality of original class would be altered by the proxy class
 * @author Ben_c
 *
 */
public class ProxyClass {
	private OriginalClass originalClass;
	
	public ProxyClass(){
		originalClass = new OriginalClass();
	}
	
	public void sayHi(){
		System.out.println("logging in proxy class");
		originalClass.sayHi();
	}
	
	public static void main(String[] args){
		ProxyClass proxyClass = new ProxyClass();
		proxyClass.sayHi();
	}
	
}
