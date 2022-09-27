package stepdefinitions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Constants;
import com.qa.util.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static final Logger LOGGER = LogManager.getLogger(LoginPageSteps.class);
	
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	
	@Given("user is on ELIS login page")
	public void user_is_on_login_page() {	
		LOGGER.info("Opening URL");
		String ELIS_URL = prop.getProperty("URL");
		DriverFactory.getDriver().get(ELIS_URL);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		LOGGER.info("Page title is:"+title);
		System.out.println("Page title is:"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {			
		Assert.assertTrue(title.contains(expectedTitle));	
	    
	}

	
	@When("user enters username")
	public void user_enters_username() {
		String username = prop.getProperty("ELIS_UserName");
		LOGGER.info("Enter User name "+username);
		loginPage.enterUserName(username);
	}

	@When("user enters password")
	public void user_enters_password() {
		String password = prop.getProperty("ELIS_PassWord");
		LOGGER.info("Enter Password (Encrypted) "+password);
		String Decrypted_Password = ElementUtil.decryptPassword(password);
		loginPage.enterPassword(Decrypted_Password);
	}
	
	@When("user click on next button")
	public void user_click_on_next_button() {
		LOGGER.info("Click on Next Button");
		loginPage.clickOnNextButton();
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		LOGGER.info("Click on Login Button");
		loginPage.clickOnLogin();
	}

	@Then("home page title should be {string}")
	public void home_page_title_should_be(String string) {
	    
	}
	
	
	@When("user clicks on SignIn button")
	public void user_clicks_on_SignIn_button() {
		LOGGER.info("Click on SignIn Button");
		loginPage.clickOnSignInButton();
	}


}
