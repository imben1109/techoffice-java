package com.techoffice.example.model;

import com.opencsv.bean.CsvBind;

public class Person {
	@CsvBind
	private String name;
	@CsvBind
	private String title;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
