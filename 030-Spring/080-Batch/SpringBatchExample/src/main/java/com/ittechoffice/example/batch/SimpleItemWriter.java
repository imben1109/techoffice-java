package com.ittechoffice.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class SimpleItemWriter implements ItemWriter<String>{

	public void write(List<? extends String> items) throws Exception {
		for (String item: items){
			System.out.println("SimpleItemWriter write: " + item);
		}
	}

}
