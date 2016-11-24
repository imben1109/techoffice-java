package com.techoffice.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Appl {
	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(new File(Appl.class.getClassLoader().getResource("test.txt").getPath()), StandardCharsets.UTF_8);
		for(String line: lines){
			System.out.println(line);
		}
	}
}
