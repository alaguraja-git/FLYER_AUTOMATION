package stepdefinitions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.MMSDWIViewerPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MMSDWIViewerPageStep {
	
	private static String title;
	private MMSDWIViewerPage MMSDWIViewerPage = new MMSDWIViewerPage(DriverFactory.getDriver());
	private static final Logger LOGGER = LogManager.getLogger(MMSDWIViewerPage.class);
	
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	
	@Given("user is on MMS_DWI Viewer Page")
	public void user_is_on_MMS_DWI_Viewer_Page() {	
		LOGGER.info("OPENING URL");
		String MMSDWI_URL = prop.getProperty("URL");
		DriverFactory.getDriver().get(MMSDWI_URL);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() throws InterruptedException {
		title = MMSDWIViewerPage.getLoginPageTitle();
		LOGGER.info("PAGE TITLE--->:"+title);
		System.out.println("PAGE TITLE--->:"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {			
		Assert.assertTrue(title.contains(expectedTitle));	
	    
	}
	
	@Then("I Select Site Value {string} under drop down box")
	public void i_select_site_value_under_drop_down_box(String sitevalue) throws InterruptedException {
		LOGGER.info("Selecting Site Value from drop down box");
		System.out.println("Selecting Site Value from drop down box");
		//MMSDWIViewerPage.selectSiteDropDown(sitevalue);	
		
		Assert.assertEquals("THE GIVEN SITE DROP DOWN VALUE IS NOT AVAILABLE UNDER PRODUCT AREA---> "+sitevalue,true, MMSDWIViewerPage.selectSiteDropDown(sitevalue));
		
	}
	
		
	@Then("I Select Product Area {string} under drop down box")
	public void i_select_product_area_under_drop_down_box(String productarea) throws InterruptedException {
		LOGGER.info("Selecting Product Area from drop down box");
		System.out.println("Selecting Product Area from drop down box");
		//MMSDWIViewerPage.selectProductAreaDropDown(productarea);
		
		Assert.assertEquals("THE GIVEN PRODUCT AREA DROP DOWN VALUE IS NOT AVAILABLE UNDER PRODUCT AREA---> "+productarea,true, MMSDWIViewerPage.selectProductAreaDropDown(productarea));
	}
	
	@Then("I Select Product Family {string} under drop down box")
	public void i_select_product_family_under_drop_down_box(String productfamily) throws InterruptedException {
		LOGGER.info("Selecting Product Family from drop down box");
		System.out.println("Selecting Product Family from drop down box");
		//MMSDWIViewerPage.selectProductFamilyDropDown(productfamily);
		
		Assert.assertEquals("THE GIVEN PRODUCT FAMILY DROP DOWN VALUE IS NOT AVAILABLE UNDER PRODUCT AREA---> "+productfamily,true, MMSDWIViewerPage.selectProductFamilyDropDown(productfamily));
	}
	
	@Then("I Select Location Value {string} under drop down box")
	public void i_select_location_value_under_drop_down_box(String locationvalue) throws InterruptedException {
		LOGGER.info("Selecting Location Value from drop down box");
		System.out.println("Selecting Location Value from drop down box");
		//MMSDWIViewerPage.selectLocationDropDown(locationvalue);
		
		Assert.assertEquals("THE GIVEN LOCATION DROP DOWN VALUE IS NOT AVAILABLE UNDER PRODUCT AREA---> "+locationvalue,true, MMSDWIViewerPage.selectLocationDropDown(locationvalue));
		
	}
	
	@Then("I click on LoadInstructionButton in the bottom")
	public void i_click_on_LoadInstruction_Button() throws InterruptedException {
		LOGGER.info("Click on Load Instruction Button");
		System.out.println("Click on Load Instruction Button");
		MMSDWIViewerPage.clickLoadInstructionButton();
		
	}
	
	@Then("I check the title {string} of the doanloaded page")
	public void I_check_the_title_of_the_downloaded_page(String title) throws InterruptedException {
		LOGGER.info("check the title of the seperate new downloaded page");
		System.out.println("check the title of the seperate new downloaded pag");
		
		Assert.assertEquals("DOWNLOAD WINDOW NOT AVAILABLE",true, MMSDWIViewerPage.checkDownloadedPageTitle(title));
		//MMSDWIViewerPage.checkDownloadedPageTitle(title);	
		
	}
	
	
	@Then("I check the title {string} of the Fail doanloaded page")
	public void I_check_the_title_of_the_Fail_downloaded_page(String title) throws InterruptedException {
		LOGGER.info("check the title of the seperate new Fail downloaded page");
		System.out.println("check the title of the seperate new Fail downloaded pag");
		
		Assert.assertEquals("DOWNLOAD WINDOW NOT AVAILABLE",true, MMSDWIViewerPage.checkFailDownloadedPageTitle(title));
		//MMSDWIViewerPage.checkDownloadedPageTitle(title);	
		
	}
	
}