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

	@Given("^open application in \"([^\"]*)\"$")
	public void open_application_in(String browser) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 
		  System.setProperty("webdriver.chrome.driver","/Users/aniketmalusare/Documents/chromedriver");
		  driver = new ChromeDriver();
		 
	  
	  driver.get("http://localhost:8080/demoPoc/");
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
		  fullName = "BhargavAbhijeetBhupatkar";
	}

	@Then("^full Name is displayed$")
	public void full_Name_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Homepage homepage = new Homepage(driver);
		   System.out.println("getFullName : "+homepage.getFullName());
		   Assert.assertEquals(fullName , homepage.getFullName());
	}

}
