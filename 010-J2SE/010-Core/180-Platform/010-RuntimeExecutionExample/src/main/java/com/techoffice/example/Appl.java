package com.techoffice.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Appl {
	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		File VbsHelloWorldFile = new File("VbsHelloWorld.vbs");
		String cmd = "cscript //Nologo " + VbsHelloWorldFile.getAbsolutePath();
		System.out.println("Command " + cmd);
		Process process = Runtime.getRuntime().exec(cmd);
		List<String> lines = IOUtils.readLines(process.getInputStream(), StandardCharsets.UTF_8);
		for (String line: lines){
			System.out.println(line);
		}
	}
}
