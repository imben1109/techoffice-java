package com.techoffice.example;

public class StudentBuilder {

	private String name;
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student build() {
		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		return student;
	}
}
