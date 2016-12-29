package com.techoffice.example;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.techoffice.example.model.Person;

public class Appl {

	public static void main(String[] args) throws URISyntaxException, IOException {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Person Name", "name");
		mapping.put("Person Title", "title");
		CSVReader reader = new CSVReader(new FileReader("test.csv"));
		HeaderColumnNameTranslateMappingStrategy<Person> strategy = new HeaderColumnNameTranslateMappingStrategy<Person>();
		strategy.setType(Person.class);
		strategy.setColumnMapping(mapping);
		CsvToBean<Person> csvToBean = new CsvToBean<Person>();
		List<Person> persons = csvToBean.parse(strategy, reader);
		reader.close();
		for (Person person : persons) {
			System.out.println(person.getName() + " " + person.getTitle());
		}
	}
}
