package com.ittechoffice.example.batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

public class BatchExtractor {
	private String path;
	private String outputPath;
	
	public BatchExtractor(String docxPath, String outputPath){
		this.path = docxPath;
		this.outputPath = outputPath;
	}
	
	public void run() throws Exception{
		File dir = new File(path);
		File[] files = dir.listFiles();
		for (int i=0; i<files.length; i++){
			File file = files[i];
			if (file.getName().endsWith(".docx") && !file.isHidden()){
				System.out.println("Extracting " + file.getName() + "...");
				String content = DocxExtractor.extract(file);
				FileOutputStream outputFileStream = null;
				BufferedWriter bufferedWriter = null;
				OutputStreamWriter writer = null;
				try {
					String filename = file.getName().substring(0, file.getName().length() - 4) + ".txt";
					File outputFile = new File(outputPath, filename);
					outputFileStream = new FileOutputStream(outputFile);
					writer = new OutputStreamWriter(outputFileStream);
					bufferedWriter = new BufferedWriter(writer);
					bufferedWriter.write(content);
				} catch (IOException e) {
					throw e;
				}finally {
					bufferedWriter.close();
					writer.close();
					outputFileStream.close();
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		String home = Paths.get(BatchExtractor.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		String outputPath = home + "\\output";
		String path = "";
		
		BatchExtractor batchExtractor = new BatchExtractor(path, outputPath);
		batchExtractor.run();
	}
	
	
	
}
