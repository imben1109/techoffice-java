package com.techoffice.example;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Appl {
	public static void main(String[] args){
		File phantomJsPath = new File("phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		System.setProperty("phantomjs.binary.path", phantomJsPath.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		driver.quit();
		System.out.println(pageSource);
	}
}
