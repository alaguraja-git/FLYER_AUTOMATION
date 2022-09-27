package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Constants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	private static final Logger LOGGER = LogManager.getLogger(HomePageSteps.class);
	
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {		
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		LOGGER.info("Opening URL");
		String ELIS_URL = prop.getProperty("URL");
		DriverFactory.getDriver().get(ELIS_URL);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		homePage = loginPage.doLogin(userName, password);
	    
	}

	@Given("user is on Home page")
	public void user_is_on_home_page() {		
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is: " + title);	
		LOGGER.info("Home Page title is: " + title);	
	}

	@Then("user gets home page headers section")
	public void user_gets_home_page_headers_section(DataTable sectionsTable) {
		
		List<String> expHomePageSectionsList = sectionsTable.asList();
		
		System.out.println("Expected Home Page section list: " + expHomePageSectionsList);

		List<String> actualHomePageSectionsList = homePage.getHomePageSectionsList();
		System.out.println("Actual Home Page section list: " + actualHomePageSectionsList);

		Assert.assertTrue(expHomePageSectionsList.containsAll(actualHomePageSectionsList));
	    
	}

}
