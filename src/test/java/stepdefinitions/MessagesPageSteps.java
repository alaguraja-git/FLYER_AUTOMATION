package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MessagesPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessagesPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private MessagesPage messagePage=new MessagesPage(DriverFactory.getDriver());
	
	@When("select under district user drop down {string} dropdown")
	public void select_under_district_user_drop_down(String message) {		
				
		messagePage.selectDistrictAdmin(message);
	   
	}

	@Then("enter the {string} and {string}")
	public void enter_the_and(String subject, String subMessage) {		
		messagePage.enterSubjectAndMessage(subject, subMessage);	    
	}

	@Then("click on send button")
	public void click_on_send_button() {
		messagePage.clickOnMessageSendButton();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	@Then("sent message should be displayed {string}")
	public void sent_message_should_be_displayed(String expectedMessage) {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Actual_Message = messagePage.sentMessage();	
		System.out.println("Expected Message--->"+expectedMessage);
		System.out.println("Actual Message----->"+Actual_Message);
		Assert.assertTrue(expectedMessage.contains(Actual_Message));    
	}
	
	// District Admin - School
	@When("select under school user drop down {string}")
	public void select_under_school_user_drop_down(String message) {		
				
		messagePage.selectDistrictAdmin_School(message);
	   
	}
	
	@Then("enter the School {string} and {string}")
	public void enter_the_school_and(String subject, String subMessage) {		
		messagePage.enterSubjectAndMessage_School(subject, subMessage);	    
	}

}
