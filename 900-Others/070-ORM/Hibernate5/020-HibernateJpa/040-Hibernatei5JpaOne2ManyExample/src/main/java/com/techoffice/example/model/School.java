package com.techoffice.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "School")
public class School {

	@Id
    @SequenceGenerator(name="school_seq",sequenceName="school_seq")        
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="school_seq")
	private int id;

	private String name;
	
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
	private List<Student> students;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		for (Student student: students){
			student.setSchool(this);
		}
		this.students = students;
	}
	
	
}
