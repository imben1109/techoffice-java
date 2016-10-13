package com.ittechoffice.example.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class SimpleItemReader implements ItemReader<String>{

	private List<String> items;
	
	public SimpleItemReader(){
		items = new ArrayList<String>();
		items.add("1");
		items.add("2");
		items.add("3");
	}
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (!items.isEmpty()){
			String item = items.remove(0);
			System.out.println("SimpleItemReader read: " + item);
			return item;	
		}
		return null;
	}

}
