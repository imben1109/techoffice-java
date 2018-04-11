package com.techoffice.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Test {

	public static void main(String[] args) throws URISyntaxException, IOException{
		Path path = Paths.get(Test.class.getClassLoader().getResource("mapper").toURI());
		FileWatchDog fileWatchDog = new FileWatchDog(path);
		fileWatchDog.run();
	}
}
