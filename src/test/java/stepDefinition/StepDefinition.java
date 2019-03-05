package stepDefinition;

import java.io.File;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.Homepage;
import utilities.ConfigFileReader;

public class StepDefinition {
public static WebDriver driver;

ConfigFileReader configreader;
String fullName;
//File file;
public String url;
public String driverP;


@Given("^User is on Demo Application$")
public void user_is_on_Demo_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 	
	
		configreader = new ConfigFileReader();
	 	url = configreader.getAppUrlNightlyEnv();
	 	driverP = configreader.getDriverPath();
	 	
	 	System.out.println(url+"\n"+driverP);
		System.setProperty("webdriver.chrome.driver",driverP);
		driver = new ChromeDriver();
		 
	  
		driver.get(url);
		driver.manage().window().maximize();
	 
	
	}

@When("^User enter \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String firstname, String middlename ,String lastname) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Homepage homepage = new Homepage(driver);
	  homepage.enterFirstName(firstname);
	  homepage.enterLastName(lastname);
	  homepage.enterMiddleName(middlename);
	  
	  fullName = firstname +" "+middlename+" "+ lastname;
	  
	}


@When("^User submits the form$")
public void user_submits_the_form() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Homepage homepage = new Homepage(driver);
	homepage.clickBtn();
	
}



@Then("^full name is displayed$")
public void full_name_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Homepage homepage = new Homepage(driver);
	   System.out.println("getFullName : "+homepage.getFullName());
	   Assert.assertEquals(fullName , homepage.getFullName());
	}
	
	
	
	


	
}
