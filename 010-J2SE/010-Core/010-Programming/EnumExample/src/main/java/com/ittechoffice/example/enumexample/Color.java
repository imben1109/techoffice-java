package com.ittechoffice.example.enumexample;

public enum Color {
	RED("RED", 1), BLUE("BLUE", 2), YELLOW("YELLOW", 3);
	
	private String name; 
	private int index;
	
	private Color(String name, int index){
		this.name = name;
		this.index = index;
	}
	
	public String getName(){
		return name;
	}
	
	public int getIndex(){
		return index;
	}
	
	@Override
	public String toString(){
		return index + "_" + name;
	}
}
