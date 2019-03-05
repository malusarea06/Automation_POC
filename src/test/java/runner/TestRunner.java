package runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;


import org.junit.runner.RunWith;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinition.Hooks;
import stepDefinition.StepDefinition;
import utilities.ExtentReport;
//import utilities.AzureReport;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature/MyFeature.feature",
		glue= {"stepDefinition"},
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		
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
 //       String temp = ExtentReport.capture(StepDefinition.driver);
     
        Properties p = System.getProperties();
        p.list(System.out);
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os Name", System.getProperty("os.name"));
        Reporter.setSystemInfo("os Version", System.getProperty("os.version"));
        Reporter.setTestRunnerOutput("Test runner output message");  
//        Reporter.addScreenCaptureFromPath(temp);					//add screenshot to report
//        extent.flush();  
        StepDefinition.driver.close();
    }
	
	
	
}
