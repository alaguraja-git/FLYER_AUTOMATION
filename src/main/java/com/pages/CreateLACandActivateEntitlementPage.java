package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

public class CreateLACandActivateEntitlementPage {
	
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(CreateLACandActivateEntitlementPage.class);
	
	
	Constants xmlFunctions = new Constants();
    String filePath = "src\\test\\resources\\testdata\\";
    String fileName = "PostXML.xml";
    

    String elementName = "Item";
    String attributeName = "entitlementLAC";
    
    boolean checkIfFileExists=true;
    String XMLStringFile=null;
    String XMLResponse = "";
    String entitlementLAC =""; 
    String actualActivationName="";
    String QTY1_CurrentValue="";
    String QTY2_CurrentValue="";
    String QTY3_CurrentValue="";
	

	
	// By Locators CreateLACandActivateEntitlementPage view scenario
		private By PostXMLIcon = By.cssSelector("#HomeWidgets > a.homePageWidget.menu\\.tools\\.XML_POSTING");
		private By inputXML = By.xpath("//textarea[@name=\"inputXML\"]");
		private By PostXMLButton = By.cssSelector("div.buttons > a");
		private By ResponseXML = By.xpath("//textarea[@name='outputXML']");
		private By Ericsson_Logo = By.cssSelector("#Header > a.ericssonLogo");
		private By LAC_Activate = By.cssSelector("div.buttons a.btn.btn-primary");
		private By LAC_Button = By.xpath("//input[@name='quickKeysAuthorizationKey']");
		private By Add_HR_Link = By.cssSelector("#SearchCriteriaSection > div.form-container > div:nth-child(2) > a");
		private By Add_HR_Resource_Name = By.xpath("//input[@name='machineName']");
		private By SaveButton = By.xpath("//a[contains(text(),'Save')]");
		private By NextButton = By.xpath("//a[contains(text(),'Next')]");
		private By Fingerprint = By.cssSelector("#TechInfo > div.form-group > input");		
		private By Fingerprint_QTY1 = By.xpath("//*[@id=\"ActivationItemList\"]/div[7]/table/tbody/tr[1]/td[1]/input[2]");
		private By Fingerprint_QTY2 = By.xpath("//*[@id=\"ActivationItemList\"]/div[7]/table/tbody/tr[2]/td[1]/input[2]");
		private By Fingerprint_QTY3 = By.xpath("//*[@id=\"ActivationItemList\"]/div[7]/table/tbody/tr[3]/td[1]/input[2]");		
		private By FingerPrint_NextButton = By.xpath("//div[@class=\"buttons\"]/a[contains(text(),'Next')]");
		private By FingerPrint_FinishButton = By.xpath("//div[@class=\"buttons\"]/a[contains(text(),'Finish')]");
		private By FingerPrint_emailid = By.xpath("//*[@id=\"emailToDiv\"]/input");
		private By ViewFunctionalSpecification = By.xpath("//a[contains(text(),'View Functional Specification')]");
		private By Transcations_tab = By.cssSelector("#poeticform > div > ul>li:nth-child(5)");
		private By ActivationName = By.xpath("//tr[@class='tableRowOdd']/td[contains(text(),'New activation')]");
		private By ViewDetails = By.xpath("//tr[@class='tableRowOdd']/td/a[contains(text(),'View Details')]");		
		private By ViewDetails_CurrentValue_QTY1 = By.xpath("//*[@id=\"poeticform\"]/div/div[8]/table/tbody/tr[1]/td[7]");
		private By ViewDetails_CurrentValue_QTY2 = By.xpath("//*[@id=\"poeticform\"]/div/div[8]/table/tbody/tr[2]/td[7]");
		private By ViewDetails_CurrentValue_QTY3 = By.xpath("//*[@id=\"poeticform\"]/div/div[8]/table/tbody/tr[3]/td[7]");
	
	// 2. Constructor of the page class
	public CreateLACandActivateEntitlementPage(WebDriver driver) {

		this.driver = driver;

	}

	// 3. page actions: features (Behavior) of the page the form of methods:

	//Click clickPostXMLIcon Icon
		public void clickPostXMLIcon() {
			try {
			ElementUtil.highlightElement(driver.findElement(PostXMLIcon));
			LOGGER.info("CLICK ON PostXMl ICON");
			driver.findElement(PostXMLIcon).click();
			}catch (Exception e) {
				System.out.println("PostXMLIcon Element not found... Trying to find it one more time using explicit wait");
				LOGGER.info("PostXMLIcon Element not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(PostXMLIcon));
				}catch(Exception e2) {
					System.out.println("PostXMLIcon Icon Element not found... Please check the Locator used..");
					LOGGER.info("PostXMLIcon Icon Element not found... Please check the Locator used..");
				}
				}
		}
		
		
		// Check XML FIle is available under the test data folder
		public void checkFileIsAvailable() {
			
			LOGGER.info("Calling Check FIle Exist Method");
			boolean checkIfFileExists = xmlFunctions.checkIfFileExist(filePath, fileName);
			if(checkIfFileExists)
			{
				LOGGER.info("Input XML file is available under Test Data Folder");
			}
			else
			{
				LOGGER.info("Input XML file is not available under Test Data Folder...Please check....");
			}	
			
			
		}
		
		// convert XML function to String and enter valid xml file
		public void convertXMLtoString() throws InterruptedException {
			
			LOGGER.info("Calling Convert XML Document to String.....");
			
			if(checkIfFileExists)
				{
				LOGGER.info("Input XML file is available");
				XMLStringFile = xmlFunctions.convertXMLDocumentToString(filePath, fileName); 
				}else
				{
					LOGGER.info("Input XML file is not available");
				}	
			try {
				ElementUtil.highlightElement(driver.findElement(inputXML));
				LOGGER.info("CLICK ON INPUT XMl Text Area");
				driver.findElement(inputXML).sendKeys(XMLStringFile);
				Thread.sleep(0);
			}catch (Exception e) {
				System.out.println("Element not found... Trying to find it one more time using explicit wait");
				LOGGER.info("Element not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(inputXML));
				}catch(Exception e2) {
					System.out.println("Element not found... Please check the Locator used..");
					LOGGER.info("Element not found... Please check the Locator used..");
				}
			}
			
		}
		
		
		//Click clickPostXMLIcon Icon
			public void clickPostXMLButton() {
					try {
					ElementUtil.highlightElement(driver.findElement(PostXMLButton));
					LOGGER.info("CLICK ON PostXMl Button");
					driver.findElement(PostXMLButton).click();
					}catch (Exception e) {
						System.out.println("PostXMLButton Element not found... Trying to find it one more time using explicit wait");
						LOGGER.info("PostXMLButton Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(PostXMLButton));
						}catch(Exception e2) {
							System.out.println("PostXMLButton Icon Element not found... Please check the Locator used..");
							LOGGER.info("PostXMLButton Icon Element not found... Please check the Locator used..");
						}
						}
				}
		
		
			//Get the response xml and store in a String
			public void getResponseXMLandConvertToString() {
					try {
					ElementUtil.highlightElement(driver.findElement(ResponseXML));
					LOGGER.info("Get the xml from ResponseXML");
					XMLResponse = driver.findElement(ResponseXML).getText();
					System.out.println(XMLResponse);
					LOGGER.info(XMLResponse);
					}catch (Exception e) {
						System.out.println("ResponseXML Element not found... Trying to find it one more time using explicit wait");
						LOGGER.info("ResponseXML Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(ResponseXML));
						}catch(Exception e2) {
							System.out.println("ResponseXML Icon Element not found... Please check the Locator used..");
							LOGGER.info("ResponseXML Icon Element not found... Please check the Locator used..");
						}
						}
				}
		
			// Check XML FIle is available under the test data folder
			public void getLACNumber() throws InterruptedException {
				
				LOGGER.info("Get LAC Number");
				entitlementLAC = xmlFunctions.fetchElementByIdFromString(XMLResponse, elementName , attributeName);
				Thread.sleep(2000);
				System.out.println("return value of entitlementLAC"+entitlementLAC);
				
				
			}	
			
			// Click on Ericsson Logo to back to URL
						public void clickOnEricssonLogo() throws InterruptedException {
							System.out.println("Inside Click Click on Ericsson Logo Method");
							LOGGER.info("Inside Click Click on Ericsson Logo Method");
							
							try {
								ElementUtil.highlightElement(driver.findElement(Ericsson_Logo));
								LOGGER.info("CLICK ON PostXMl ICON");
								driver.findElement(Ericsson_Logo).click();
								}catch (Exception e) {
									System.out.println("Ericsson_Logo Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("Ericsson_Logo Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(Ericsson_Logo));
									}catch(Exception e2) {
										System.out.println("Ericsson_Logo Icon Element not found... Please check the Locator used..");
										LOGGER.info("Ericsson_Logo Icon Element not found... Please check the Locator used..");
									}
									}
							
											
							
						}		
			
			
			
						// Provide LAC in the test Area
						public void provideEntitlementLAC() {
														
							try {
								LOGGER.info("ALAGURAJA"+entitlementLAC);
								System.out.println("------------------>"+entitlementLAC);
								ElementUtil.highlightElement(driver.findElement(LAC_Button));
								LOGGER.info("CLICK ON provideEntitlementLAC ICON");
								driver.findElement(LAC_Button).sendKeys(entitlementLAC);
								}catch (Exception e) {
									System.out.println("LAC_Button Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("LAC_Button Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(LAC_Button));
									}catch(Exception e2) {
										System.out.println("LAC_Button Icon Element not found... Please check the Locator used..");
										LOGGER.info("LAC_Button Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
						// Activate LAC Button
						public void activateLACButton() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(LAC_Activate));
								LOGGER.info("CLICK ON LAC_ActivateICON");
								driver.findElement(LAC_Activate).click();
								}catch (Exception e) {
									System.out.println("LAC_Activate Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("LAC_Activate Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(LAC_Activate));
									}catch(Exception e2) {
										System.out.println("LAC_Activate Icon Element not found... Please check the Locator used..");
										LOGGER.info("LAC_Activate Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
			
		
						// Click on Add HR Lin
						public void clickAddHRLink() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(Add_HR_Link));
								LOGGER.info("CLICK ON Add_HR_Link");
								driver.findElement(Add_HR_Link).click();
								}catch (Exception e) {
									System.out.println("Add_HR_Link Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("Add_HR_Link Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(Add_HR_Link));
									}catch(Exception e2) {
										System.out.println("Add_HR_Link Icon Element not found... Please check the Locator used..");
										LOGGER.info("Add_HR_Link Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
		
		
						// Enter Add_HR_Resource_Name
						public void addHRResourceName() {
														
							try {
								String entitlementLAC_HR = entitlementLAC+"_HW";
								LOGGER.info("ALAGURAJA"+entitlementLAC_HR);
								System.out.println("------------------>"+entitlementLAC_HR);
								ElementUtil.highlightElement(driver.findElement(Add_HR_Resource_Name));
								LOGGER.info("CLICK ON provideEntitlementLAC ICON");
								driver.findElement(Add_HR_Resource_Name).sendKeys(entitlementLAC_HR);
								}catch (Exception e) {
									System.out.println("Add_HR_Resource_Name Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("Add_HR_Resource_Name Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(Add_HR_Resource_Name));
									}catch(Exception e2) {
										System.out.println("Add_HR_Resource_Name Icon Element not found... Please check the Locator used..");
										LOGGER.info("Add_HR_Resource_Name Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
		
		
						// Click on Save Button
						public void clickOnSaveButton() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(SaveButton));
								LOGGER.info("CLICK ONSaveButton");
								driver.findElement(SaveButton).click();
								}catch (Exception e) {
									System.out.println("SaveButton Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("SaveButton Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(SaveButton));
									}catch(Exception e2) {
										System.out.println("SaveButton Icon Element not found... Please check the Locator used..");
										LOGGER.info("SaveButton Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
						// Click on Next Button
						public void clickOnNextButton() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(NextButton));
								LOGGER.info("CLICK ON NextButton");
								driver.findElement(NextButton).click();
								}catch (Exception e) {
									System.out.println("NextButton Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("NextButton Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton));
									}catch(Exception e2) {
										System.out.println("NextButton Icon Element not found... Please check the Locator used..");
										LOGGER.info("NextButton Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
		
		
						// Enter Fingerprint_Name
						public void addFingerPrintName() {
														
							try {
								String entitlementLAC_FP = entitlementLAC+"_FP";
								LOGGER.info(""+entitlementLAC_FP);
								System.out.println("------------------>"+entitlementLAC_FP);
								ElementUtil.highlightElement(driver.findElement(Fingerprint));
								LOGGER.info("CLICK ON provideEntitlementLAC ICON");
								driver.findElement(Fingerprint).sendKeys(entitlementLAC_FP);
								}catch (Exception e) {
									System.out.println("Fingerprint Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("Fingerprint Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(Fingerprint));
									}catch(Exception e2) {
										System.out.println("Fingerprint Icon Element not found... Please check the Locator used..");
										LOGGER.info("Fingerprint Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
						
						
						
						// Enter Fingerprint_QTY Values
						public void provideFingerPrintQTYValues(String QTY1,String QTY2,String QTY3)throws InterruptedException{
														
							try {
										LOGGER.info("Entering QTY1 Values");
										System.out.println("Entering QTY1 Values");
										ElementUtil.highlightElement(driver.findElement(Fingerprint_QTY1));
										driver.findElement(Fingerprint_QTY1).sendKeys(QTY1);
										Thread.sleep(1000);
										LOGGER.info("Entering QTY2 Values");
										System.out.println("Entering QTY2 Values");
										ElementUtil.highlightElement(driver.findElement(Fingerprint_QTY2));
										LOGGER.info("CLICK ON provideEntitlementLAC ICON");
										driver.findElement(Fingerprint_QTY2).sendKeys(QTY2);
										Thread.sleep(1000);
										LOGGER.info("Entering QTY3 Values");
										System.out.println("Entering QTY3 Values");
										ElementUtil.highlightElement(driver.findElement(Fingerprint_QTY3));
										LOGGER.info("CLICK ON provideEntitlementLAC ICON");
										driver.findElement(Fingerprint_QTY3).sendKeys(QTY3);
									}catch (Exception e) {
										System.out.println("Fingerprint QTY Element not found... Trying to find it one more time using explicit wait");
										LOGGER.info("Fingerprint QTY Element not found... Trying to find it one more time using explicit wait");
										try {
											WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
											wait.until(ExpectedConditions.visibilityOfElementLocated(Fingerprint_QTY1));
										}catch(Exception e2) {
											System.out.println("Fingerprint Icon Element not found... Please check the Locator used..");
											LOGGER.info("Fingerprint Icon Element not found... Please check the Locator used..");
										}
										try {
											WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
											wait.until(ExpectedConditions.visibilityOfElementLocated(Fingerprint_QTY2));
										}catch(Exception e2) {
											System.out.println("Fingerprint Icon Element not found... Please check the Locator used..");
											LOGGER.info("Fingerprint Icon Element not found... Please check the Locator used..");
										}
										try {
											WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
											wait.until(ExpectedConditions.visibilityOfElementLocated(Fingerprint_QTY3));
										}catch(Exception e2) {
											System.out.println("Fingerprint Icon Element not found... Please check the Locator used..");
											LOGGER.info("Fingerprint Icon Element not found... Please check the Locator used..");
										}
								}
							
						}
		
		
		
						// Click on Next Button in FingeerPrint Page
						public void clickOnFingerPrintNextButton() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(FingerPrint_NextButton));
								LOGGER.info("clickOnFingerPrintNextButton");
								driver.findElement(FingerPrint_NextButton).click();
								}catch (Exception e) {
									System.out.println("clickOnFingerPrintNextButton Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("clickOnFingerPrintNextButton Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(FingerPrint_NextButton));
									}catch(Exception e2) {
										System.out.println("clickOnFingerPrintNextButton Icon Element not found... Please check the Locator used..");
										LOGGER.info("clickOnFingerPrintNextButton Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
		
		
		
						// Click on Finish Button in FingeerPrint Page
						public void clickOnFingerPrintFinishButton() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(FingerPrint_FinishButton));
								LOGGER.info("FingerPrint_FinishButton");
								driver.findElement(FingerPrint_FinishButton).click();
								}catch (Exception e) {
									System.out.println("FingerPrint_FinishButton Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("FingerPrint_FinishButton Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(FingerPrint_FinishButton));
									}catch(Exception e2) {
										System.out.println("FingerPrint_FinishButton Icon Element not found... Please check the Locator used..");
										LOGGER.info("FingerPrint_FinishButton Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
						
						// Click on Finish Button in FingeerPrint Page
						public void enterEmailID(String mailid) {
														
							try {
								ElementUtil.highlightElement(driver.findElement(FingerPrint_emailid));
								LOGGER.info("FingerPrint_emailid");
								driver.findElement(FingerPrint_FinishButton).sendKeys(mailid);
								}catch (Exception e) {
									System.out.println("FingerPrint_emailid Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("FingerPrint_emailid Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(FingerPrint_emailid));
									}catch(Exception e2) {
										System.out.println("FingerPrint_emailid Icon Element not found... Please check the Locator used..");
										LOGGER.info("FingerPrint_emailid Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
						
						
						
								
						// Click on ViewFunctionalSpecification
						public void clickOnViewFunctionalSpecification() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(ViewFunctionalSpecification));
								LOGGER.info("Click on ViewFunctionalSpecification");
								driver.findElement(ViewFunctionalSpecification).click();
								}catch (Exception e) {
									System.out.println("ViewFunctionalSpecification Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("ViewFunctionalSpecification Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(ViewFunctionalSpecification));
									}catch(Exception e2) {
										System.out.println("ViewFunctionalSpecification Icon Element not found... Please check the Locator used..");
										LOGGER.info("ViewFunctionalSpecification Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
						
						
		// Transcations_tab
						
						
						// Click on Transcations_tab
						public void clickOnTranscationsTab() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(Transcations_tab));
								LOGGER.info("Click on Transcations_tab");
								driver.findElement(Transcations_tab).click();
								}catch (Exception e) {
									System.out.println("Transcations_tab Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("Transcations_tab Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(Transcations_tab));
									}catch(Exception e2) {
										System.out.println("Transcations_tab Icon Element not found... Please check the Locator used..");
										LOGGER.info("Transcations_tab Icon Element not found... Please check the Locator used..");
									}
									}								
							
						}
						
		// Activation				
						
						
						
						// Click on Transcations_tab
						public String validateOnActivationName() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(ActivationName));
								LOGGER.info("Click on validateOnActivationName");
								actualActivationName =  driver.findElement(ActivationName).getText();
								LOGGER.info("ActivationName---->"+actualActivationName);
								System.out.println("ActivationName---->"+actualActivationName);
								return actualActivationName;
								}catch (Exception e) {
									System.out.println("Transcations_tab Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("Transcations_tab Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(ActivationName));
									}catch(Exception e2) {
										System.out.println("Transcations_tab Icon Element not found... Please check the Locator used..");
										LOGGER.info("Transcations_tab Icon Element not found... Please check the Locator used..");
									}
									}
							return actualActivationName;
															
							
						}			
						
						
	//ViewDetails					
						
						
						// Click on Transcations_tab
						public void clickOnViewDetails() {
														
							try {
								ElementUtil.highlightElement(driver.findElement(ViewDetails));
								LOGGER.info("Click on ViewDetails");
								driver.findElement(ViewDetails).click();
								}catch (Exception e) {
									System.out.println("ViewDetails Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("ViewDetails Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(ViewDetails));
									}catch(Exception e2) {
										System.out.println("ViewDetails link Element not found... Please check the Locator used..");
										LOGGER.info("ViewDetails Link Element not found... Please check the Locator used..");
									}
									}								
							
						}	
						
						
		//ViewDetails_CurrentValue_QTY1
						
						// Click on QTY1_CurrentValue
						public String CurrentValue_QTY1(String CurrentValue_QTY1) {
														
							try {
								ElementUtil.highlightElement(driver.findElement(ViewDetails_CurrentValue_QTY1));
								LOGGER.info("Click on validateViewDetails_CurrentValue_QTY1");
								QTY1_CurrentValue =  driver.findElement(ViewDetails_CurrentValue_QTY1).getText();
								LOGGER.info("ActivationName---->"+QTY1_CurrentValue);
								System.out.println("ActivationName---->"+QTY1_CurrentValue);
								return QTY1_CurrentValue;
								}catch (Exception e) {
									System.out.println("CurrentValue_QTY1 Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("CurrentValue_QTY1 Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(ViewDetails_CurrentValue_QTY1));
									}catch(Exception e2) {
										System.out.println("CurrentValue_QTY1 Icon Element not found... Please check the Locator used..");
										LOGGER.info("CurrentValue_QTY1 Icon Element not found... Please check the Locator used..");
									}
									}
							return QTY1_CurrentValue;
															
							
						}
						
						
						
						
						// Click on QTY2_CurrentValue
						public String CurrentValue_QTY2(String CurrentValue_QTY2) {
														
							try {
								ElementUtil.highlightElement(driver.findElement(ViewDetails_CurrentValue_QTY2));
								LOGGER.info("Click on validateViewDetails_CurrentValue_QTY2");
								QTY2_CurrentValue =  driver.findElement(ViewDetails_CurrentValue_QTY2).getText();
								LOGGER.info("ActivationName---->"+QTY2_CurrentValue);
								System.out.println("ActivationName---->"+QTY2_CurrentValue);
								return QTY2_CurrentValue;
								}catch (Exception e) {
									System.out.println("CurrentValue_QTY2 Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("CurrentValue_QTY2 Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(ViewDetails_CurrentValue_QTY2));
									}catch(Exception e2) {
										System.out.println("CurrentValue_QTY2 Icon Element not found... Please check the Locator used..");
										LOGGER.info("CurrentValue_QTY2 Icon Element not found... Please check the Locator used..");
									}
									}
							return QTY2_CurrentValue;
															
							
						}
						
						
						// Click on QTY3_CurrentValue
						public String CurrentValue_QTY3(String CurrentValue_QTY3) {
														
							try {
								ElementUtil.highlightElement(driver.findElement(ViewDetails_CurrentValue_QTY3));
								LOGGER.info("Click on validateViewDetails_CurrentValue_QTY3");
								QTY3_CurrentValue =  driver.findElement(ViewDetails_CurrentValue_QTY3).getText();
								LOGGER.info("ActivationName---->"+QTY3_CurrentValue);
								System.out.println("ActivationName---->"+QTY3_CurrentValue);
								return QTY3_CurrentValue;
								}catch (Exception e) {
									System.out.println("CurrentValue_QTY3 Element not found... Trying to find it one more time using explicit wait");
									LOGGER.info("CurrentValue_QTY3 Element not found... Trying to find it one more time using explicit wait");
									try {
										WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
										wait.until(ExpectedConditions.visibilityOfElementLocated(ViewDetails_CurrentValue_QTY3));
									}catch(Exception e2) {
										System.out.println("CurrentValue_QTY3 Icon Element not found... Please check the Locator used..");
										LOGGER.info("CurrentValue_QTY3 Icon Element not found... Please check the Locator used..");
									}
									}
							return QTY3_CurrentValue;
															
							
						}
						
						
						
						
						
						
		
}
