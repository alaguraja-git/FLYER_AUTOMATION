package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("http://www1.flyerschoolapp.com.farshore.net/messages/add");
		homePage = loginPage.doLogin(userName, password);
	    
	}

	@Given("user is on Home page")
	public void user_is_on_home_page() {		
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is: " + title);	    
	}

	@Then("user gets home page headers section")
	public void user_gets_home_page_headers_section(DataTable sectionsTable) {
		
		List<String> expHomePageSectionsList = sectionsTable.asList();
		
		System.out.println("Expected Home Page section list: " + expHomePageSectionsList);

		List<String> actualHomePageSectionsList = homePage.getHomePageSectionsList();
		System.out.println("Actual Home Page section list: " + actualHomePageSectionsList);

		Assert.assertTrue(expHomePageSectionsList.containsAll(actualHomePageSectionsList));
	    
	}

	@Then("home page headers section count should be {int}")
	public void home_page_headers_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(homePage.getHomePageSectionCount() == expectedSectionCount);	
	}

}
