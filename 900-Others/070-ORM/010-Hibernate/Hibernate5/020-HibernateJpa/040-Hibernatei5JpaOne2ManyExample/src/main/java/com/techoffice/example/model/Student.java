package com.techoffice.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id
	@SequenceGenerator(name="student_seq", sequenceName="student_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
	private int id;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
	private School school;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return id + " " + studentName;
	}

	
}
