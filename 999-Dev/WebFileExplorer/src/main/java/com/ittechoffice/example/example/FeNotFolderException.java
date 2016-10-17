package com.ittechoffice.example.example;

public class FeNotFolderException extends Exception{
	
	private static final String message = "Only folder is supported";
	
	public FeNotFolderException(){
		super(message);
	}
}
