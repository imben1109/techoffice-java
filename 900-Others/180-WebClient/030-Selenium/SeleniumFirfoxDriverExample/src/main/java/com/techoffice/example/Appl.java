package com.techoffice.example;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Appl {
	public static void main(String[] args){
		File firefoxDriverFile = new File("geckodriver-v0.12.0-win32/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", firefoxDriverFile.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		driver.close();
		driver.quit();
		System.out.println(pageSource);
	}
}
