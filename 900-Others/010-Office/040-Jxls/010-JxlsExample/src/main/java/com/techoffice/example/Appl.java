package com.techoffice.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException{
		InputStream templateIo = Appl.class.getClassLoader().getResourceAsStream("Template/template.xlsx");
		OutputStream os = new FileOutputStream("output.xlsx");
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setName("Testing User");
		list.add(user);
		Context context = new Context();
		context.putVar("user", user);
		JxlsHelper.getInstance().processTemplate(templateIo, os, context);
	}
}
