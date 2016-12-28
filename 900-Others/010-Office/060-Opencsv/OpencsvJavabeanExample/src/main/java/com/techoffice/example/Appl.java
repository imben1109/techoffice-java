package com.techoffice.example;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.techoffice.example.model.Person;

public class Appl {
	
	public static void main(String[] args) throws URISyntaxException, IOException{
	     CSVReader reader = new CSVReader(new FileReader("test.csv"));
         HeaderColumnNameMappingStrategy<Person> strategy = new HeaderColumnNameMappingStrategy<Person>();
         strategy.setType(Person.class);
         CsvToBean<Person> csvToBean = new CsvToBean<Person>();
         List<Person> persons = csvToBean.parse(strategy, reader);
	     reader.close();
	     for(Person person: persons){
	    	 System.out.println(person.getName() + " " + person.getTitle());
	     }
	}
}
