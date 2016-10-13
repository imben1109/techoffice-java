package com.ittechoffice.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * This Example show how to writer to an OutputStream using BufferedWriter
 * 
 * @author Ben_c
 *
 */
public class BufferedWriterExample {
	public static void main(String[] args) throws URISyntaxException, IOException{
		String path = Paths.get(BufferedWriterExample.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		File file = new File(path + "/output/output.txt");
		FileOutputStream fos = new FileOutputStream(file); 
		//FileOutputStream is a subclass of OutputStream
		OutputStreamWriter writer = new OutputStreamWriter(fos);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write("Testing Output");
		bufferedWriter.flush();
		bufferedWriter.close();
		writer.close();
		fos.close();
	}
}
