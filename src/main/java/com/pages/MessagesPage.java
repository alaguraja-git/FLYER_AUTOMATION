package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagesPage {

	private WebDriver driver;

	// 1. By Locators - District
	private By messageDistrict = By.cssSelector("#div_district_list > div:nth-child(3) > button:nth-child(1) > span");
	private By messageDistrict_Search = By.xpath("//div[@id='div_district_list']//following::input[@id='ms-opt-1']");
	private By messageDistrict_Select = By.cssSelector(".ms-active > div:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > label:nth-child(2) > span");
	private By sendMessage_Subject = By.xpath("//input[@id='title']");
	private By sendMessage_SendButton = By.xpath("//button[@id='message_send']");
	private By message_Sent = By.cssSelector("body > div.wrapper.active > div > section > div");
	
	// 1. By Locators - Districy School Drop Down
	
	private By SeeAllMessage_Button = By.xpath("//a[text()='See all Messages']");
	private By AddNewMessage_Button = By.xpath("//a[text()='Add New Message']");
	private By School_Dropdown = By.xpath("//div[@id='div_school_list']");
	private By School_Dropdown_Search = By.xpath("(//div[@id='div_school_list']//following::div[@class='ms-options hide-checkbox']/div/input)[1]");
	private By School_Dropdown_Select = By.xpath("(//*[@id=\"multiselmsg-id\"]/div/ul/li[17]/label/small)[2]");
	
	

	// 2. Constructor of the page class

	public MessagesPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features (Behavior) of the page the form of methods:

	public void selectDistrictAdmin(String message) {
		WebElement district_DropDown = driver.findElement(messageDistrict);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", district_DropDown);
		district_DropDown.click();

		driver.findElement(messageDistrict_Search).sendKeys(message);

		WebElement element = driver.findElement(messageDistrict_Select);

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element);
		element.click();
	}

	public void enterSubjectAndMessage(String subject, String subMessage) {
		WebElement district_DropDown = driver.findElement(messageDistrict);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", district_DropDown);
		district_DropDown.click();

		driver.findElement(sendMessage_Subject).sendKeys(subject);

		driver.findElement(sendMessage_Subject).sendKeys(Keys.TAB, subMessage);
	}
	
	public void clickOnMessageSendButton() {
		driver.findElement(sendMessage_SendButton).click();
	}
	
	public String sentMessage() {
		String Actual_Message = driver.findElement(message_Sent).getText();
		return Actual_Message;
	}
	
	// School Drop Down
	
	public void selectDistrictAdmin_School(String message) {
		
		// click on See All Message Button
		driver.findElement(SeeAllMessage_Button).click();
		
		// click on Add new Message Button
		driver.findElement(AddNewMessage_Button).click();
		
		// Click on School Drop Down Button
		WebElement School_Dropdown_Button = driver.findElement(School_Dropdown);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", School_Dropdown_Button);
		School_Dropdown_Button.click();

		driver.findElement(School_Dropdown_Search).sendKeys(message);		

		WebElement element1 = driver.findElement(School_Dropdown_Select);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element1)); 
		wait.until(ExpectedConditions.elementToBeClickable(element1));
		
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", element1);		
	}
	
	
	public void enterSubjectAndMessage_School(String subject, String subMessage) {

		driver.findElement(sendMessage_Subject).sendKeys(subject);
		driver.findElement(sendMessage_Subject).sendKeys(Keys.TAB, subMessage);			
	}

}
