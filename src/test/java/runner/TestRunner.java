package runner;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Properties;

import org.junit.After;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinition.StepDefinition;
//import utilities.AzureReport;
import utilities.ExtentReport;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature/",
		glue= {"stepDefinition"},
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		//tags = {""}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    static ExtentTest test;
    
    
    
	@BeforeClass
    public  static void setup() throws MalformedURLException {
 
		
		htmlReporter = new ExtentHtmlReporter(".//output//report.html");	
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("Demo Test");
//      sextentProperties.setReportPath("output/myreport.html");
       
    }
	
	@AfterClass
    public static void tearDown() throws Exception {
        Reporter.loadXMLConfig(new File(".//extent-config.xml"));
       // String temp = ExtentReport.capture(StepDefinition.driver);
     
        Properties p = System.getProperties();
        p.list(System.out);
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os Name", System.getProperty("os.name"));
        Reporter.setSystemInfo("os Version", System.getProperty("os.version"));
        Reporter.setTestRunnerOutput("Test runner output message");  
      //  Reporter.addScreenCaptureFromPath(temp);					//add screenshot to report
       // extent.flush();  
       // System.out.println("After Class called");
        StepDefinition.driver.close();
  
    }
	
	
}
