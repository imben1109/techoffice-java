package com.techoffice.example;

/**
 * HashCode is used to digest data stored in an instance to a single hash value (32-bit signed integer)
 * @author Ben_c
 *
 */
public class Example {
	String name;
	int id;
	
	public Example(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public int hashCode(){
		return id + name.hashCode();
	}
	
	public static void main(String[] args) throws ClassNotFoundException{
		Example e = new Example("Testing", 1);
		System.out.println(e.hashCode());
	}
}
