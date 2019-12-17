package com.techoffice.example;

import lombok.Data;

import java.util.Date;

@Data
public class User {
	private String userId;
	private String name;
	private Date dob;
	private Group customGroup;
}
