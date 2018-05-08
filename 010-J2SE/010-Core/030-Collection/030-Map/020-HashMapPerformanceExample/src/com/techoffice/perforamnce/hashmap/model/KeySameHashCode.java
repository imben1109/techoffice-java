package com.techoffice.perforamnce.hashmap.model;

public class KeySameHashCode {

	private int key;
	
	public KeySameHashCode(int key){
		this.key = key;
	}
	
	public int getKey(){
		return this.key;
	}
	
	public int hashCode(){
		return 1;
	}
}
