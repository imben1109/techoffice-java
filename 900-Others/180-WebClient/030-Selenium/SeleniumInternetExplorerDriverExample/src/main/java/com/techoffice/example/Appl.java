package com.techoffice.example;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Appl {
	public static void main(String[] args){
		File internetExplorerDriverFile = new File("IEDriverServer_Win32_2.53.1/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", internetExplorerDriverFile.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		driver.quit();
		System.out.println(pageSource);
	}
}
