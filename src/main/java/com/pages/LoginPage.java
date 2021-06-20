package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators
	private By emailid = By.id("email");
	private By password = By.id("password");
	private By loginButton = By.id("login_button");
	private By forgotPwdLink = By.linkText("Forgot Password?");

	// 2. Constructor of the page class

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// 3. page actions: features (Behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean isForgetPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();

	}

	public void enterUserName(String username) {
		driver.findElement(emailid).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}
	
	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}
