package com.techoffice;

import java.io.FileInputStream;
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

import com.techoffice.model.User;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException{
		String home = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		InputStream is = new FileInputStream(home + "/Template/template.xlsx");
		OutputStream os = new FileOutputStream(home + "/Output/output.xlsx");
		List<User> list = ApplHelper.getUserList();
		Context context = new Context();
		context.putVar("userList", list);
		JxlsHelper.getInstance().processTemplate(is, os, context);
	}
}
