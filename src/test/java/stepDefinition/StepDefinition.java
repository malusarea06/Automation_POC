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
@Given("^I am on Demo Application$")
public void i_am_on_Demo_Application() throws Throwable {
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

	@When("^i enter \"([^\"]*)\" and \"([^\"]*)\" and\"([^\"]*)\"$")
	public void i_enter_and(String firstname, String middlename ,String lastname) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Homepage homepage = new Homepage(driver);
	  homepage.enterFirstName(firstname);
	  homepage.enterLastName(lastname);
	  homepage.enterMiddleName(middlename);
	  homepage.clickBtn();
	  fullName = firstname +" "+middlename+" "+ lastname;
	  
	}

	@Then("^full name is displayed$")
	public void full_name_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Homepage homepage = new Homepage(driver);
	   System.out.println("getFullName : "+homepage.getFullName());
	   Assert.assertEquals(fullName , homepage.getFullName());
	}
	
	
	
	@Given("^open application in Chrome$")
	public void open_application_in_Chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.setProperty("webdriver.chrome.driver","/Users/aniketmalusare/Documents/chromedriver");
		  driver = new ChromeDriver();	  
		  driver.get("http://localhost:8085/demoPoc/");
		  driver.manage().window().maximize();
	}

	@When("^i enter firstname and middlename and lastname$")
	public void i_enter_firstname_and_middlename_and_lastname() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Homepage homepage = new Homepage(driver);
		  homepage.enterFirstName("Bhargav");
		  homepage.enterMiddleName("Abhijeet");
		  homepage.enterLastName("Bhupatkar");
		  homepage.clickBtn();
		  fullName = "Bhargav Abhijeet Bhupatkar";
	}

	@Then("^full Name is displayed$")
	public void full_Name_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Homepage homepage = new Homepage(driver);
		   System.out.println("getFullName : "+homepage.getFullName());
		   Assert.assertEquals(fullName , homepage.getFullName());
	}

}
