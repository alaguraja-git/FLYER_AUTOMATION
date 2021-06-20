package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**	 *This method is used to initialize the ThreadLocal driver on the basis of given browser
	 * @param browser
	 * @return
	 */

	public WebDriver init_driver(String browser)	{
		
		System.out.println("Browser value is--->"+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();			
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}else if(browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		}else
		{
			System.out.println("Please pass the correct browser value"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	/**
	 * This is used to get to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}
	
	
	
	
	
	
}
