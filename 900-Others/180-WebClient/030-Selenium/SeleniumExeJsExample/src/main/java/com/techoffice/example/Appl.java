package com.techoffice.example;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Appl {
	public static void main(String[] args) {

		File chromeDriverFile = new File("chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.google.com");

			if (driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) driver).executeScript("alert('hello world');");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}
}
