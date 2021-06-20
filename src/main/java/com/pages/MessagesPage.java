package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage {
	
	private WebDriver driver;

	// 1. By Locators
	private By messageDistrict = By.xpath("//div[@class='tag-close-container district-tags']/ul");
	private By messageDistrict_Search = By.xpath("");
	private By messageDistrict_Select = By.xpath("");
	private By sendMessage_Subject = By.xpath("//input[@id='title']");
	private By sendMessage_EnterMessage = By.xpath("//iframe[@id=\"msg_body_ifr\"]");
	private By sendMessage_SendButton = By.xpath("//button[@id='message_send']");
	
	// 2. Constructor of the page class

		public MessagesPage(WebDriver driver) {

			this.driver = driver;

		}

		// 3. page actions: features (Behavior) of the page the form of methods:
		
		

	
	

}
