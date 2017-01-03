package com.techoffice.factory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	
	private static WebDriver webDriver;
	
	static {
		File chromeDriverFile = new File("chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		webDriver = new ChromeDriver();
	}
	
	public static WebDriver getWebDriver(){
		return webDriver;
	}
	
}
