package com.techoffice.json.convertor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Program {
	public static void main(String[] args) throws IOException{
		File inputFile = new File("C:\\Users\\panwaicheng\\git\\bosv_dev\\src\\WebContent\\i18n\\report-en.json");
		File outputFile = new File("output.json");
		List<String> inputlines = FileUtils.readLines(inputFile);
		List<String> outputLines = JsonStringValueConvertor.covert(inputlines);
		FileUtils.writeLines(outputFile, outputLines);
	}
}
