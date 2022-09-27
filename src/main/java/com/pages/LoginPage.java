package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;
import com.qa.util.Constants;
import com.qa.util.ElementUtil;


public class LoginPage {

	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	

	// 1. By Locators
	private By emailid = By.id("i0116");
	private By clickNext = By.id("idSIButton9");
	private By password = By.id("passwordInput");
	private By loginButton = By.id("submitButton");
	private By pickAnAccount = By.xpath("//*[@id=\"tilesHolder\"]/div[1]/div/div[1]/div");
	private By signInButton = By.id("submitButton1");

	// 2. Constructor of the page class

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// 3. page actions: features (Behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		LOGGER.info("Get the Page Title");
		return driver.getTitle();

	}	
	
	public void clickPickAnAccount() {
		driver.findElement(pickAnAccount).click();
	}

	public void enterUserName(String username) {
		try {
				ElementUtil.highlightElement(driver.findElement(emailid));
				LOGGER.info("Entered the USERNAME");
				driver.findElement(emailid).sendKeys(username);
			}catch (Exception e) {
			System.out.println("Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(emailid));
			}catch(Exception e2) {
				System.out.println("Element not found... Please check the Locator used..");
				LOGGER.info("Element not found... Please check the Locator used..");
			}
			}
	}

	public void enterPassword(String pwd) {
		try {
			ElementUtil.highlightElement(driver.findElement(password));
			LOGGER.info("Entered the PASSWORD");
			driver.findElement(password).sendKeys(pwd);
		}catch (Exception e) {
			System.out.println("Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(password));
			}catch(Exception e2) {
				System.out.println("Element not found... Please check the Locator used..");
				LOGGER.info("Element not found... Please check the Locator used..");
			}
			}
	}
	
	public void clickOnNextButton() {
		try {
			ElementUtil.highlightElement(driver.findElement(clickNext));
			LOGGER.info("Click on NEXT BUTTON");
			driver.findElement(clickNext).click();
		}catch (Exception e) {
			System.out.println("Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(clickNext));
			}catch(Exception e2) {
				System.out.println("Element not found... Please check the Locator used..");
				LOGGER.info("Element not found... Please check the Locator used..");
			}
			}
	}

	public void clickOnLogin() {
		try {
		ElementUtil.highlightElement(driver.findElement(loginButton));
		LOGGER.info("Click on SIGN IN BUTTON");
		driver.findElement(loginButton).click();
		Thread.sleep(1000);
		}catch (Exception e) {
			System.out.println("Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
			}catch(Exception e2) {
				System.out.println("Element not found... Please check the Locator used..");
				LOGGER.info("Element not found... Please check the Locator used..");
			}
			}
	}
	
	
	// Need to Delete
	
	public void clickOnSignInButton() {
		try {
		ElementUtil.highlightElement(driver.findElement(signInButton));
		LOGGER.info("CLICK ON SIGN IN BUTTON");
		driver.findElement(signInButton).click();
		}catch (Exception e) {
			System.out.println("SignInButton Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("SignInButton Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
			}catch(Exception e2) {
				System.out.println("SignInButton Element not found... Please check the Locator used..");
				LOGGER.info("SignInButton Element not found... Please check the Locator used..");
			}
			}
	}	
	
	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		LOGGER.info("Login with:"+ un + " and " +pwd);
		try {
		ElementUtil.highlightElement(driver.findElement(emailid));
		LOGGER.info("Entered the USERNAME");
		driver.findElement(emailid).sendKeys(un);
		Thread.sleep(1000);
		ElementUtil.highlightElement(driver.findElement(clickNext));
		LOGGER.info("CLICK ON NEXT BUTTON");
		driver.findElement(clickNext).click();
		Thread.sleep(1000);
		ElementUtil.highlightElement(driver.findElement(password));
		LOGGER.info("Entered the PASSWORD");
		String Decrypted_Password = ElementUtil.decryptPassword(pwd);
		driver.findElement(password).sendKeys(Decrypted_Password);
		Thread.sleep(1000);
		ElementUtil.highlightElement(driver.findElement(loginButton));
		LOGGER.info("CLICK ON SIGNIN BUTTON");
		driver.findElement(loginButton).click();
		Thread.sleep(1000);
		}catch (Exception e) {
			System.out.println("Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
			}catch(Exception e2) {
				System.out.println("Element not found... Please check the Locator used..");
				LOGGER.info("Element not found... Please check the Locator used..");
			}
			}
		return new HomePage(driver);	
			

}
}
