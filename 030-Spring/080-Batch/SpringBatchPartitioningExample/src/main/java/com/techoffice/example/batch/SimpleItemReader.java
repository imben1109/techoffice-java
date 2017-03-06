package com.techoffice.example.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;

public class SimpleItemReader implements ItemReader<String>{
	
	private String param1;
	private String param2;
	
	private List<String> items;
	
	public SimpleItemReader(){
		items = new ArrayList<String>();
		items.add("1");
		items.add("2");
		items.add("3");
	}
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println(param1);
		System.out.println(param2);
		if (!items.isEmpty()){
			String item = items.remove(0);
			System.out.println("SimpleItemReader read: " + item);
			return item;	
		}
		return null;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}
	
	

}
