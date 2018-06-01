package com.techoffice;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Appl {

	public static void main(String[] args) throws ParseException{
		
		args = new String[3];
		args[0] = "-t";
		args[1] = "Testing";
		args[2] = "-w";
		
		Options options = new Options();
		options.addOption("t", true, "display current time");
		options.addOption("w", false, "display current time");
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse( options, args);

		if(cmd.hasOption("t")) {
			System.out.println("With parameter t");
			String tOptionValue = cmd.getOptionValue("t");
			System.out.println(tOptionValue);
		}
		
		if(cmd.hasOption("w")) {
			System.out.println("With parameter w");
			String wOptionValue = cmd.getOptionValue("w");
			System.out.println(wOptionValue);
		}
		
		if(!cmd.hasOption("t") && cmd.hasOption("w")) {
		    System.out.println("Without any parameter");
		}

	}
	
}
