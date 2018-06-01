package com.techoffice.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.w3c.tidy.Tidy;

public class Appl {
	public static void main(String[] args){
		Tidy tidy = new Tidy();
		tidy.setXHTML(true);
		String xml = "<!DOCTYPE HTML><!-- -- -- --><html></html>";
		OutputStream out = new ByteArrayOutputStream();
		tidy.parse(new ByteArrayInputStream(xml.getBytes()), out);
		System.out.println(out.toString());
	}
}
