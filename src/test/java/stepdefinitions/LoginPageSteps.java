package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {		
		DriverFactory.getDriver().get("http://www1.flyerschoolapp.com.farshore.net/");	    
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is:"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {			
		Assert.assertTrue(title.contains(expectedTitle));	
	    
	}

	@Then("forgot your password link should be displayed")	
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgetPwdLinkExist());	    
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("home page title should be {string}")
	public void home_page_title_should_be(String string) {
	    
	}


}
