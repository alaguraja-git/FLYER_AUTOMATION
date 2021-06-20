package stepdefinitions;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MessagesPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessagesPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private MessagesPage messagePage;
	
	@When("select under district user drop down {string}")
	public void select_under_district_user_drop_down(String string) {
	    
	}

	@Then("enter the {string} and {string}")
	public void enter_the_and(String string, String string2) {
	    
	}

	@Then("click on send button")
	public void click_on_send_button() {
	    
	}

}
