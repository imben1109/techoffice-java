package com.ittechoffice.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Example show how to read InputStream from BufferedReader
 * 
 * @author Ben_c
 *
 */
public class BufferedReaderExample {
	public static void main(String[] args) throws IOException{
		String filePath =  BufferedReaderExample.class.getClassLoader().getResource("test.txt").getFile();
		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		// File Input Stream is a sub class of Input Stream 
		InputStreamReader reader = new InputStreamReader(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line ;
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
		bufferedReader.close();
		reader.close();
		fileInputStream.close();
	}
}
