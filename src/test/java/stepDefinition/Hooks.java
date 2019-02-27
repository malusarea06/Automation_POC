package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;


public class Hooks {

	
	@After
	public void closebrowser()
	{
	//	AzureReport.generateReport();
		StepDefinition.driver.close();
	}
}
