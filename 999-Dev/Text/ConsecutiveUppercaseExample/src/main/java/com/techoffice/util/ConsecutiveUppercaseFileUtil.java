package com.techoffice.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.techoffice.model.ConsecutiveUppercaseFile;
import com.techoffice.model.ConsecutiveUppercaseLine;

/**
 * Consecutive Uppercase File Utility
 * 
 * @author Ben Cheng
 *
 */
public class ConsecutiveUppercaseFileUtil {

	private ConsecutiveUppercaseFileUtil(){}
	
	/**
	 * Get Consecutive Uppercase File 
	 * 
	 * @param file 
	 * @return Consecutive Uppercase File
	 * 
	 * @throws IOException
	 */
	public static ConsecutiveUppercaseFile getConsecutiveUppercaseLineList(File file) throws IOException{
		ConsecutiveUppercaseFile consecutiveUppercaseFile = new ConsecutiveUppercaseFile(file);		
		List<ConsecutiveUppercaseLine> consecutiveUppercaseLineList = new ArrayList<ConsecutiveUppercaseLine>();
		List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
		int lineNum=1;
		for (String line: lines){
			List<String> consecutiveUppercaseStrList = ConsecutiveUppercaseStringUtil.getConsecutiveUppercaseStrList(line);
			if(consecutiveUppercaseStrList != null && consecutiveUppercaseStrList.size() > 0 ){
				ConsecutiveUppercaseLine consecutiveUppercaseLine = new ConsecutiveUppercaseLine(lineNum, consecutiveUppercaseStrList);	
				consecutiveUppercaseLineList.add(consecutiveUppercaseLine);
			}
			lineNum++;
		}
		consecutiveUppercaseFile.setConsecutiveUppercaseLineList(consecutiveUppercaseLineList);
		if (consecutiveUppercaseLineList.size() > 0){
			consecutiveUppercaseFile.setConsecutiveUppercase(true);
		}else{
			consecutiveUppercaseFile.setConsecutiveUppercase(false);
		}
		return consecutiveUppercaseFile;
	}
	
	/**
	 * Get Formatted Report of the Consecutive Uppercase File
	 * 
	 * @param consecutiveUppercaseFile Consecutive Uppercase File
	 * @return Formatted Report of Consecutive Uppercase File
	 */
	public static String getFormattedReport(ConsecutiveUppercaseFile consecutiveUppercaseFile){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(consecutiveUppercaseFile.getFile().getAbsolutePath());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("=================================================================");
		stringBuilder.append(System.lineSeparator());
		List<ConsecutiveUppercaseLine> consecutiveUppercaseLineList = consecutiveUppercaseFile.getConsecutiveUppercaseLineList();
		if (consecutiveUppercaseLineList.size() > 0){
			String str = String.format("%-10s %50s %n", "Line Number", "Consecutive Uppercase Word List");
			stringBuilder.append(str);
		}
		
		for (ConsecutiveUppercaseLine consecutiveUppercaseLine: consecutiveUppercaseLineList){
			String str = String.format("%-10s %50s %n", consecutiveUppercaseLine.getLine(), StringUtils.join(consecutiveUppercaseLine.getUppercaseStrList(), ", "));
			stringBuilder.append(str);
		}
		stringBuilder.append("=================================================================");
		stringBuilder.append(System.lineSeparator());
		return stringBuilder.toString();
	} 
	
	/**
	 * Get Formatted Report of the Consecutive Uppercase Files with specified extension in specified folder  
	 * 
	 * @param folder
	 * @param extenstions
	 * @return Formatted Report of Consecutive Uppercase Files
	 * @throws IOException
	 */
	public static String getFormattedReport(File folder, String[] extenstions) throws IOException{
		ByteArrayOutputStream btyeArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(btyeArrayOutputStream, true);
		Collection<File> files = FileUtils.listFiles(folder, extenstions, true);
		Iterator<File> fileIterator = files.iterator();
		while(fileIterator.hasNext()){
			File file = fileIterator.next();
			ConsecutiveUppercaseFile consecutiveUppercaseFile =  ConsecutiveUppercaseFileUtil.getConsecutiveUppercaseLineList(file);
			if (consecutiveUppercaseFile.isConsecutiveUppercase()){
				printStream.println(ConsecutiveUppercaseFileUtil.getFormattedReport(consecutiveUppercaseFile));	
			}
		}
		printStream.close();
		String content = new String(btyeArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
		return content;
	}
	
	/**
	 * Print Formatted Report of the Consecutive Uppercase Files to a specified file
	 * 
	 * @param outputFile 
	 * @param folder
	 * @param extenstions
	 * @throws IOException
	 */
	public static void outputFormattedReport(File outputFile, File folder, String[] extenstions) throws IOException{
		String content = ConsecutiveUppercaseFileUtil.getFormattedReport(new File("C:\\Users\\panwaicheng\\git\\bosv_dev\\src\\WebContent\\sys\\pages"), new String[]{"html"});
		FileUtils.writeStringToFile(outputFile, content, StandardCharsets.UTF_8);
	}
}
