package com.techoffice.example;

import spark.Spark;

public class Appl {
	public static void main(String[] args){
		Spark.port(8080);
		Spark.get("/", (req, res) -> "Tech Office Spark Example");
		Spark.get("Hello", (req, res) -> "Hello World");
	}
}
