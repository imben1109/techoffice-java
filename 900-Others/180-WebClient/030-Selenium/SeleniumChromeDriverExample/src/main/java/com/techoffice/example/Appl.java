package com.techoffice.example;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Appl {
	public static void main(String[] args){
		File chromeDriverFile = new File("chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		driver.quit();
		System.out.println(pageSource);
	}
}
