package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;

public class Appl {
	public static void main(String[] args) throws IOException, URISyntaxException{
		Path path = Paths.get(Appl.class.getClassLoader().getResource(".").toURI());
		File root = path.getParent().getParent().toFile();
		File Testing = new File(root, "/src/main/java/com/ittechoffice/example/Testing.java");
		String content = FileUtils.readFileToString(Testing, "UTF-8");
		JavaClassSource javaClass =
				  Roaster.parse(JavaClassSource.class, content);
		List<MethodSource<JavaClassSource>> methods = javaClass.getMethods();
		System.out.println(javaClass.getName());
		for (MethodSource<JavaClassSource> method: methods){
			System.out.println(method.getName());
		}
	}
}
