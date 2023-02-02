package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/features/"},
		glue = {"stepdefinitions","AppHooks"},
				plugin = {"pretty",				
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"html:target/cucumber-html-report",
						"json:target/cucumber.json",
						"junit:target/cucumber.xml",
						"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
						"timeline:test-output-thread/"				
				},
		monochrome=true
		)
public class MyTestRunner {

}

