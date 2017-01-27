package com.techoffice.example.batch;

import org.springframework.batch.item.ItemProcessor;

import com.techoffice.example.model.Student;

public class SimpleProcessor implements ItemProcessor<Student, String>{

	public String process(Student item) throws Exception {
		String input = item.getName();
		String output = "Processed " + input;
		System.out.println("SimpleProcessor input: " + input);
		System.out.println("SimpleProcessor input: " + output);
		return output;
	}

}
