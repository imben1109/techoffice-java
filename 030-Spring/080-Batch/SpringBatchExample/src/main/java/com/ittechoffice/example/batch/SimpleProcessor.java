package com.ittechoffice.example.batch;

import org.springframework.batch.item.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, String>{

	public String process(String item) throws Exception {
		String input = item;
		String output = "Processed " + input;
		System.out.println("SimpleProcessor input: " + input);
		System.out.println("SimpleProcessor input: " + output);
		return output;
	}

}
