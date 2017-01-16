package com.techoffice.example;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.techoffice.example.model.Person;

public class Appl {

	public static void main(String[] args) throws URISyntaxException, IOException {
		List<Person> persons = new ArrayList<Person>();
		Person person1 = new Person();
		person1.setName("Person 1");
		person1.setTitle("Title 1");
		Person person2 = new Person();
		person2.setName("Person 2");
		person2.setTitle("Title 2");
		Person person3 = new Person();
		person3.setName("Person 3");
		person3.setTitle("Title 3");
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		CSVWriter writer = new CSVWriter(new FileWriter("test.csv"));
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Person Name", "name");
		mapping.put("Person Title", "title");
		HeaderColumnNameTranslateMappingStrategy<Person> strategy = new HeaderColumnNameTranslateMappingStrategy<Person>();
		strategy.setColumnMapping(mapping);
		strategy.setType(Person.class);
		BeanToCsv<Person> beanToCsv = new BeanToCsv<Person>();
		beanToCsv.write(strategy, writer, persons);
		writer.close();

	}
}
