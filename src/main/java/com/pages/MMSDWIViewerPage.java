package com.pages;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ConfigReader;
import com.qa.util.Constants;
import com.qa.util.ElementUtil;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;



public class MMSDWIViewerPage {
	
private WebDriver driver;
	
	private static final Logger LOGGER = LogManager.getLogger(MMSDWIViewerPage.class);
	private ElementUtil Util = new ElementUtil();
	private Constants myConst = new Constants();
	
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
		
	
		// 1. By Locators	
		private By siteValue = By.xpath("//*[@id='siteHolder']/div/ul");
		private By SiteDropDown = By.xpath("//*[@id='siteHolder']");
	
		private By productArea = By.xpath("//*[@id='areasHolder']/div/ul/li");
		private By productAreaDropDown = By.xpath("//*[@id='dropdownAreas']");
		
		private By productFamily = By.xpath("//*[@id='productFamilyHolder']/div/ul/li");
		private By productFamilyDropDown = By.xpath("//*[@id='ProductFamilyPath']");
		
		private By location = By.xpath("//*[@id='languageHolder']/div/ul/li");
		private By locationDropDown = By.xpath("//*[@id='dropdownLanguage']");
		
		private By LoadInstructions = By.xpath("//button[contains(text(),'Load Instruction')]");
		
		private By newWindowTitle = By.xpath("//*[contains(text(),'GetInstructionFile')]");

		// 2. Constructor of the page class

		public MMSDWIViewerPage(WebDriver driver) {
			this.driver = driver;
		}

		// 3. page actions: features (Behavior) of the page the form of methods:

		public String getLoginPageTitle() throws InterruptedException {
			LOGGER.info("Get the Page Title");
			System.out.println("Get the Page Title");
			return driver.getTitle();
		}
		
		
		//Select Drop Down Value
		public boolean selectSiteDropDown(String SiteValueElement ) throws InterruptedException {		
			
			LOGGER.info("SELECTING THE SITE DROP DOWN VALUE");
			System.out.println("SELECTING THE SITE DROP DOWN VALUE");
			
			WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SiteDropDown));
			
			ElementUtil.highlightElement(driver.findElement(SiteDropDown));
			
			LOGGER.info("CLICK THE SITE DROP DOWN");
			System.out.println("CLICK THE SITE DROP DOWN");
			
			driver.findElement(SiteDropDown).click();
			
			LOGGER.info("CHECKING THE SITE DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
			System.out.println("CHECKING THE SITE DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");		
			
			WebDriverWait wait1 = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(siteValue));
						
			List<WebElement> listOfElements = driver.findElements(siteValue);
			
			boolean isFound = false;
			
				for (WebElement element : listOfElements) 
				{
					
					if (element.getText().contains(SiteValueElement)) 
					{
						LOGGER.info("YES---> SITE DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+SiteValueElement);
						System.out.println("YES---> SITE DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+SiteValueElement);
						
						element.click();
						isFound = true;
						return true;
					}	
				}
				
				if (!isFound)
				{
					System.out.println("THE SITE DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+SiteValueElement);
					LOGGER.info("THE SITE DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+SiteValueElement);
					return false;
				}
				return true;
			
		}
		
		//Select Product Area Drop Down Value
				@SuppressWarnings("deprecation")
				public boolean selectProductAreaDropDown(String productareaElement ) throws InterruptedException {
					
						LOGGER.info("SELECTING THE PRODUCT AREA DROP DOWN VALUE");
						System.out.println("SELECTING THE PRODUCT AREA DROP DOWN VALUE");						
						ElementUtil.sleepTime();
						
						ElementUtil.highlightElement(driver.findElement(productAreaDropDown));
						
						LOGGER.info("CLICK THE PEODUCT AREA DROP DOWN VALUE");
						System.out.println("CLICK THE PRODUCT AREA DROP DOWN VALUE");						
						ElementUtil.sleepTime();
						
						driver.findElement(productAreaDropDown);			
						
						
						driver.findElement(productAreaDropDown).click();	
						
						//ElementUtil.clickElement(driver.findElement(productAreaDropDown));
						
						LOGGER.info("CHECKING THE PRODUCT AREA DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
						System.out.println("CHECKING THE PRODUCT AREA DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
						
							List<WebElement> listOfElements = driver.findElements(productArea);		
							boolean isFound = false;
						
							for (WebElement element : listOfElements) 
							{							
								if (element.getText().contains(productareaElement)) 
								{
									LOGGER.info("YES---> PEODUCT AREA DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+productareaElement);
									System.out.println("YES---> PEODUCT AREA DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+productareaElement);
									
									element.click();
									isFound = true;
									return true;
								}	
							}
							
							if (!isFound)
							{
								System.out.println("NO---> THE PRODUCT AREA DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+productareaElement);
								LOGGER.info("NO---> THE PRODUCT AREA DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+productareaElement);
								return false;
							}
							return true;
			}
		
		
				//Select Product Family Drop Down Value
				
				public boolean selectProductFamilyDropDown(String productFamilyElement ) throws InterruptedException 
				{
					LOGGER.info("SELECTING THE PRODUCT FAMILY DROP DOWN VALUE");
					System.out.println("SELECTING THE PRODUCT FAMILY DROP DOWN VALUE");
					
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(productFamilyDropDown));
					ElementUtil.sleepTime();					
					
					ElementUtil.highlightElement(driver.findElement(productFamilyDropDown));
					
					LOGGER.info("CLICK THE PEODUCT FAMILY DROP DOWN VALUE");
					System.out.println("CLICK THE PRODUCT FAMILY DROP DOWN VALUE");
					ElementUtil.sleepTime();
					
					driver.findElement(productFamilyDropDown).click();				
					
					LOGGER.info("CHECKING THE PRODUCT FAMILY DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
					System.out.println("CHECKING THE PRODUCT FAMILY DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
					
					WebDriverWait wait1 = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(productFamily));
					
					List<WebElement> listOfElements = driver.findElements(productFamily);		
					boolean isFound = false;
					
						for (WebElement element : listOfElements) 
						{
							
							if (element.getText().contains(productFamilyElement)) 
							{
								LOGGER.info("YES---> PEODUCT FAMILY DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+productFamilyElement);
								System.out.println("YES---> PEODUCT FAMILY DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+productFamilyElement);
								
								element.click();
								isFound = true;
								return true;
							}	
						}
						
						if (!isFound)
						{
							System.out.println("NO---> THE PRODUCT FAMILY DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+productFamilyElement);
							LOGGER.info("NO---> THE PRODUCT FAMILY DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+productFamilyElement);
							return false;
						}
						return true;				
					
				}
		

				
				public boolean selectLocationDropDown(String locationValueElement ) throws InterruptedException 
				{
					LOGGER.info("SELECTING THE LOCATION DROP DOWN VALUE");
					System.out.println("SELECTING THE LOCATION DROP DOWN VALUE");
					
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(locationDropDown));
					ElementUtil.sleepTime();
					
					ElementUtil.highlightElement(driver.findElement(locationDropDown));
					
					LOGGER.info("CLICK THE LOCATION DROP DOWN VALUE");
					System.out.println("CLICK THE LOCATION DROP DOWN VALUE");
					ElementUtil.sleepTime();
					
					driver.findElement(locationDropDown).click();				
								
					LOGGER.info("CHECKING THE LOCATION DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
					System.out.println("CHECKING THE LOCATION DROP DOWN VALUE IS PRESENT IN THE DROP DOWN");
					
					
					WebDriverWait wait1 = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(location));
					
					List<WebElement> listOfElements = driver.findElements(location);		
					boolean isFound = false;
					
						for (WebElement element : listOfElements) 
						{
							
							if (element.getText().contains(locationValueElement)) 
							{
								LOGGER.info("YES---> LOCATION DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+locationValueElement);
								System.out.println("YES---> LOCATION DROP DOWN ELEMANT IS PRESENT. SO CLICKING THE ELEMENT--->"+locationValueElement);
								
								element.click();
								isFound = true;
								return true;
							}	
						}
						
						if (!isFound)
						{
							System.out.println("NO---> THE LOCATION DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+locationValueElement);
							LOGGER.info("NO---> THE LOCATION DROP DOWN VALUE IS NOT PRESENT UNDER DROP DOWN....PLEASE GIVE PROPER DROP DOWN ELEMENT--->"+locationValueElement);
							return false;
						}
						return true;				
					
				}
				
				
				//Click on Load Instruction Button
				public void clickLoadInstructionButton() {
					
					try 
					{
						
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(LoadInstructions));
					ElementUtil.sleepTime();
					
					ElementUtil.highlightElement(driver.findElement(LoadInstructions));
					
					LOGGER.info("CLICK ON LOAD INSTRUCTION BUTTON");
					System.out.println("CLICK ON LOAD INSTRUCTION BUTTON");
					
					driver.findElement(LoadInstructions).click();
					ElementUtil.sleepTime();
					}catch (Exception e) {
						System.out.println("Load Instruction Button not found... Trying to find it one more time using explicit wait");
						LOGGER.info("Load Instruction Button not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(LoadInstructions));
						}catch(Exception e2) {
							System.out.println("Load Instruction Button not found... Please check the Locator used..");
							LOGGER.info("Load Instruction Button not found... Please check the Locator used..");
						}
						}
				}
				
				
				//Check the title of the downloaded page
				public boolean checkDownloadedPageTitle(String title) throws InterruptedException {
					
								
					try 
					{
						LOGGER.info("CHECKING DOWNLOAD PAHE TITLE IS PRESENT OR NOT");
						System.out.println("CHECKING DOWNLOAD PAHE TITLE IS PRESENT OR NOT");
						
						String parentWindow=driver.getWindowHandle();
						
						System.out.println("Parent Window Title------->"+parentWindow);
						
						Set<String>windows=driver.getWindowHandles();
						System.out.println("GET WINDOW HANDLES---->"+windows);
						
						int i=0;
						for (String window : windows) 
						{ 
							driver.switchTo().window(window);
							
							String ExpectedURL = driver.getCurrentUrl();
							if(i==1) 
							{					
								// /Default/GetInstructionFile?path=
									if (ExpectedURL.contains("/Default/GetInstructionFile?path=")){
										
										LOGGER.info("YES --->DOWNLOAD PAHE TITLE IS PRESENT");
										System.out.println("YES --->DOWNLOAD PAHE TITLE IS PRESENT");
							
										return true;
									}
									else
									{
										LOGGER.info("NO --->DOWNLOAD PAHE TITLE IS NOT PRESENT");
										System.out.println("NO --->DOWNLOAD PAHE TITLE IS NOT PRESENT");
										return false;
									}
									
							}
							
							i=i+1;
						}
						
					}catch (Exception e) {
						System.out.println("parentWindow not found... Trying to find it one more time using explicit wait");
						LOGGER.info("parentWindow not found... Trying to find it one more time using explicit wait");
						}
					return true;
				}
				
				
				//Check the title of the downloaded page
				public boolean checkFailDownloadedPageTitle(String title) throws InterruptedException {
					
										
					try 
					{
						
						String parentWindow=driver.getWindowHandle();
						
						System.out.println("Parent Window Title------->"+parentWindow);
						
						Set<String>windows=driver.getWindowHandles();
						System.out.println("GET WINDOW HANDLES---->"+windows);
						
						int i=0;
						for (String window : windows) 
						{ 
							driver.switchTo().window(window);
							
							String ExpectedURL = driver.getCurrentUrl();
							if(i==1) 
							{					
								// /Default/GetInstructionFile?path=
									if (ExpectedURL.contains("AMAMA")){
							
										return true;
									}
									else
									{
										return false;
									}
									
							}
							
							i=i+1;
						}
						
					}catch (Exception e) {
						System.out.println("parentWindow not found... Trying to find it one more time using explicit wait");
						LOGGER.info("parentWindow not found... Trying to find it one more time using explicit wait");
						}
					return true;
				}
		
}
