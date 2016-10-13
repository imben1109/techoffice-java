package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import com.sun.codemodel.JClassAlreadyExistsException;

public class Appl {
	public static void main(String[] args) throws JClassAlreadyExistsException, IOException, URISyntaxException{
		PojoGenerator PojoGenerator = new PojoGenerator("", "User");
		PojoGenerator.addField(String.class, "name");
		PojoGenerator.addField(String.class, "lname");
		String root = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		PojoGenerator.generateCode(new File(root + "/Output"));
	}
}
