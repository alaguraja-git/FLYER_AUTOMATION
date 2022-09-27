package stepdefinitions;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.CreateLACandActivateEntitlementPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Then;

public class CreateLACandActivateEntitlementSteps {
	
	private CreateLACandActivateEntitlementPage LACActivate = new CreateLACandActivateEntitlementPage(DriverFactory.getDriver());
	private HomePage homePage;
	private static final Logger LOGGER = LogManager.getLogger(CreateLACandActivateEntitlementSteps.class);
	
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	
	
	
	@Then("click on postxml icon in home page")
	public void click_on_postxml_icon_in_home_page() {
		LOGGER.info("Clicking PostXMl Icon");
		LACActivate.clickPostXMLIcon();
		LOGGER.info("Sucessfully Clicked PostXML Icon");
	   
	}

	@Then("enter the valid xml file in inputXML text box")
	public void enter_the_valid_xml_file_in_inputXML_text_box() throws InterruptedException {		
		LOGGER.info("Checking inputXML file is exist or not under Test Data Folder");
		LACActivate.checkFileIsAvailable();
		LOGGER.info("Verified XMl File is available under Test Data Folder...");
		LACActivate.convertXMLtoString();
		LOGGER.info("Converted XMl File in to String and enter xml file in to INPUT XML Text Area");
		LOGGER.info("Click on Post XML Button..........after enter xml file");
		LACActivate.clickPostXMLButton();
		LOGGER.info("Sucessfully clicked Post XML Button..........after enter xml file");
		Thread.sleep(1000);
		
	}
	
	@Then("check the availability of created LAC in response xml file")
	public void check_the_availability_of_created_lac_in_response_xml_file() throws InterruptedException {
		
		LOGGER.info("check the availability of created LAC in response xml file");
		LACActivate.getResponseXMLandConvertToString();
		Thread.sleep(2000);
		LACActivate.getLACNumber();		
	    
	}
	
	
	
	
	@Then("provide valid LAC and click on Activation Link")
	public void provide_valid_LAC_and_click_on_Activation_Link() throws InterruptedException {
		LOGGER.info("Click on Ericsson Logo to back to URL");
		LACActivate.clickOnEricssonLogo();
		LOGGER.info("Sucessfully clicked and back to URL");	
		LOGGER.info("Provide Valid LAC in LAC Text Area");
		Thread.sleep(2000);
		LACActivate.provideEntitlementLAC();
		LOGGER.info("Sucessfully provideEntitlementLAC");
		Thread.sleep(2000);
		LOGGER.info("Click on Activate Button");
		LACActivate.activateLACButton();
		Thread.sleep(2000);
		LOGGER.info("Sucessfully Clicked the Activate Button");
		Thread.sleep(2000);		
	}
	
	
	
	@Then("provide values to HR Resource Name and Fingerprint fields")
	public void provide_values_to_HR_Resource_Name_and_Fingerprint_fields() throws InterruptedException {
		LOGGER.info("click on Add_HR_Link Element");
		Thread.sleep(3000);
		LACActivate.clickAddHRLink();
		LOGGER.info("Sucessfully clicked Add_HR_Link Element");
		Thread.sleep(1000);
		LOGGER.info("provide values to HR Resource Name and Fingerprint fields");
		LACActivate.addHRResourceName();
		Thread.sleep(3000);
		LOGGER.info("Sucessfully provide values to HR Resource Name and Fingerprint fields");
		
		LOGGER.info("Click Save Button");
		LACActivate.clickOnSaveButton();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully clicked Save Button");
		
		LOGGER.info("Click Next Button");
		LACActivate.clickOnNextButton();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully clicked Next Button");
		
		LOGGER.info("addFingerPrintName");
		LACActivate.addFingerPrintName();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully added addFingerPrintName");
		
		
	}
	
	@Then("provide valid values {string} and {string} and {string} as per Activation Validation Rules")
	public void provide_valid_values_and_as_per_activation_validation_rules(String QTY1, String QTY2, String QTY3) throws InterruptedException {
	   
		LOGGER.info("addFingerPrintName");
		LACActivate.provideFingerPrintQTYValues(QTY1,QTY2,QTY3);
		Thread.sleep(1000);
		LOGGER.info("Sucessfully added addFingerPrintName");
		
	}	
	
	
	@Then("click on Next Button")
	public void click_on_next_Button() throws InterruptedException {
		Thread.sleep(2000);
		LOGGER.info("Clicking Next Button");
		LACActivate.clickOnFingerPrintNextButton();
		Thread.sleep(3000);
		LOGGER.info("Sucessfully Clicked Next Button");
	   
	}
	
	@Then("enter mail id {string} and click on Finish Button")
	public void click_on_Finish_Button(String mailid) throws InterruptedException {
		LOGGER.info("Entering Email ID in the Email Field");
		LACActivate.enterEmailID(mailid);
		LOGGER.info("Clicking finish Button");
		LACActivate.clickOnFingerPrintFinishButton();
		Thread.sleep(3000);
		LOGGER.info("Sucessfully Clicked Finish Button");
	   
	}
	
	@Then("click on view summary and validate {string} name")
	public void click_on_view_summary_and_validate(String activationName) throws InterruptedException {
		Thread.sleep(2000);
		LOGGER.info("Clicking on ViewFunctionalSpecification");
		LACActivate.clickOnViewFunctionalSpecification();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully Clicked on ViewFunctionalSpecification");
		
		LOGGER.info("Clicking on Transcations_tab");
		LACActivate.clickOnTranscationsTab();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully Clicked on Transcations_tab");
		
		LOGGER.info("validate activationName");
		String actual_ActivationName = LACActivate.validateOnActivationName();
		Thread.sleep(1000);
		Assert.assertTrue(actual_ActivationName.contains(activationName));
		LOGGER.info("Sucessfully validated activationName");
		
	}
	
	@Then("click on view details")
	public void click_on_view_details() throws InterruptedException {
		Thread.sleep(1000);
		LOGGER.info("Clicking view details");
		LACActivate.clickOnViewDetails();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully Clicked view details");
	   
	}
	
	
	@Then("validate view transcation details {string} and {string} and {string} values")
	public void validate_view_transcation_details_and_values(String CurrentValue_QTY1, String CurrentValue_QTY2, String CurrentValue_QTY3) throws InterruptedException {
		
		LOGGER.info("validate CurrentValue_QTY1");
		String actual_QTY1ActivationName = LACActivate.CurrentValue_QTY1(CurrentValue_QTY1);
		Thread.sleep(1000);
		Assert.assertTrue(actual_QTY1ActivationName.contains(CurrentValue_QTY1));
		LOGGER.info("Sucessfully validated CurrentValue_QTY1");
		
		LOGGER.info("validate CurrentValue_QTY2");
		String actual_QTY2ActivationName = LACActivate.CurrentValue_QTY2(CurrentValue_QTY2);
		Thread.sleep(1000);
		Assert.assertTrue(actual_QTY2ActivationName.contains(CurrentValue_QTY2));
		LOGGER.info("Sucessfully validated CurrentValue_QTY2");
		
		LOGGER.info("validate CurrentValue_QTY3");
		String actual_QTY3ActivationName = LACActivate.CurrentValue_QTY3(CurrentValue_QTY3);
		Thread.sleep(1000);
		Assert.assertTrue(actual_QTY3ActivationName.contains(CurrentValue_QTY3));
		LOGGER.info("Sucessfully validated CurrentValue_QTY3");
		
		
	}
	
	

}
