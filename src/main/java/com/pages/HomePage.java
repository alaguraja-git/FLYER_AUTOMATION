package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	// 1. By Locators
	private By homeSections = By.xpath("//section/ul/li/a");
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
	
		

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		LOGGER.info("Get the Home Page Title");
		return driver.getTitle();
	}	

	public List<String> getHomePageSectionsList() {

		List<String> homeList = new ArrayList<>();
		List<WebElement> homeHeaderList = driver.findElements(homeSections);

		for (WebElement e : homeHeaderList) {
			String text = e.getText();
			System.out.println(text);
			homeList.add(text);
		}

		return homeList;
	}
}


