package com.techoffice.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import com.techoffice.example.SxssfJxlsHelper.SxssfJxlsHelperException;


public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException, EncryptedDocumentException, InvalidFormatException, SxssfJxlsHelperException{
		InputStream templateIo = Appl.class.getClassLoader().getResourceAsStream("Template/template.xlsx");
		OutputStream os = new FileOutputStream("output.xlsx");
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setName("Testing User");
		
		for (int i=0; i<100000; i++){
			users.add(user);
		}
		
		System.out.println(users.size());
		Context context = new Context();
		context.putVar("user", user);
		context.putVar("users", users);
		SxssfJxlsHelper.processTemplate(templateIo, os, context);



		//JxlsHelper.getInstance().processTemplate(templateIo, os, context);
	}
}
