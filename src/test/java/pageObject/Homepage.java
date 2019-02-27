package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
@FindBy(id="firstName")
WebElement txtfname;

@FindBy(id="lastName")
WebElement txtlname;

@FindBy(css="button.signupbtn")
WebElement btnsubmit;

@FindBy(id="fullName")
WebElement txtfullname;

public Homepage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}


public void enterFirstName(String fname)
{
	
	txtfname.sendKeys(fname);
	}


public void enterLastName(String lname)
{
	
	txtlname.sendKeys(lname);
	}

public void clickBtn()
{
	
	btnsubmit.click();
	}


public String getFullName()
{
	return txtfullname.getAttribute("value");
	}
}
