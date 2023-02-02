package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	
	public WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**	 *This method is used to initialize the ThreadLocal driver on the basis of given browser
	 * @param browser
	 * @return
	 */

	public WebDriver init_driver(String browser)	{
		
		System.out.println("Browser value is--->"+browser);
		LOGGER.info("Browser value is--->"+browser);
		
		if(browser.equals("chrome")) {
			LOGGER.info("Chrome browser setup is in progress");
			WebDriverManager.chromedriver().setup();			
			tlDriver.set(new ChromeDriver());
			LOGGER.info("Chrome browser setup completed");
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
			LOGGER.info("Please pass the correct browser value"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		LOGGER.info("Deleted All the Cookies");
		getDriver().manage().window().maximize();
		LOGGER.info("Chrome browser window is maximized");
		getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
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
