package com.techoffice;

import java.io.File;
import java.io.IOException;

import com.techoffice.util.ConsecutiveUppercaseFileUtil;

public class Appl {
		
	public static void main(String[] args) throws IOException {
		ConsecutiveUppercaseFileUtil.outputFormattedReport(new File("report.txt"), new File("testingData"), new String[]{"txt"});
	}
	
}
