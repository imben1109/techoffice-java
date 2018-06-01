package com.techoffice.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.techoffice.util.ProcessUtil;
import com.techoffice.util.ProcessUtilException;

public class Appl {
	public static void main(String[] args) throws  ProcessUtilException, IOException{
		File VbsHelloWorldFile = new File("VbsHelloWorld.vbs");
		String cmd = "cscript //Nologo " + VbsHelloWorldFile.getAbsolutePath();
		System.out.println("Command: " + cmd);
		Process process = Runtime.getRuntime().exec(cmd);
		long processId = ProcessUtil.getProcessId(process);
		System.out.println("Process ID: " + processId);
		
		System.out.println("=== Process Output ===");
		List<String> lines = IOUtils.readLines(process.getInputStream(), StandardCharsets.UTF_8);
		for (String line: lines){
			System.out.println(line);
		}
	}
}
