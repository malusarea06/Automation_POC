package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.Homepage;

public class StepDefinition {
static WebDriver driver;
String fullName;
String url = "http://localhost:8888/demoPoc/";

	@Given("^open application in \"([^\"]*)\"$")
	public void open_application_in(String browser) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 
		  System.setProperty("webdriver.chrome.driver",".//Resource//chromedriver");
		  driver = new ChromeDriver();
		 
	  
	  driver.get(url);
	  driver.manage().window().maximize();
	 
	
	}

	@When("^i enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String firstname, String lastname) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Homepage homepage = new Homepage(driver);
	  homepage.enterFirstName(firstname);
	  homepage.enterLastName(lastname);
	  homepage.clickBtn();
	  fullName = firstname +" "+ lastname;
	  
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

	@When("^i enter firstname and lastname$")
	public void i_enter_firstname_and_lastname() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Homepage homepage = new Homepage(driver);
		  homepage.enterFirstName("Bhargav");
		  homepage.enterLastName("Bhupatkar");
		  homepage.clickBtn();
		  fullName = "Bhargav Bhupatkar";
	}

	@Then("^full Name is displayed$")
	public void full_Name_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Homepage homepage = new Homepage(driver);
		   System.out.println("getFullName : "+homepage.getFullName());
		   Assert.assertEquals(fullName , homepage.getFullName());
	}

}
