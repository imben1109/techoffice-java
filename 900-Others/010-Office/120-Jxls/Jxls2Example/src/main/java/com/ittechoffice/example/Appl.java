package com.ittechoffice.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException{
		String home = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		InputStream is = new FileInputStream(home + "/Template/template.xlsx");
		OutputStream os = new FileOutputStream(home + "/Output/output.xlsx");
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setName("Testing User");
		list.add(user);
		Context context = new Context();
		context.putVar("user", user);
		JxlsHelper.getInstance().processTemplate(is, os, context);
	}
}
