package com.techoffice.example;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import com.opencsv.CSVReader;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException{
	     CSVReader reader = new CSVReader(new FileReader("test.csv"));
	     String [] nextLine;
	     while ((nextLine = reader.readNext()) != null) {
	        System.out.println(nextLine[0] + " " + nextLine[1]);
	     }
	     reader.close();
	}
}
