package runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		tags = {"@Newtest"}
		)
//
public class TestRunner extends AbstractTestNGCucumberTests{
	static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    static ExtentTest test;
	@BeforeClass
    public  static void setup() throws MalformedURLException {
 
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		 
//        extentProperties.setReportPath("output/myreport.html");
       
    }
	
	@AfterClass
    public static void teardown() throws Exception {
        Reporter.loadXMLConfig(new File(".//extent-config.xml"));
     
        Properties p = System.getProperties();
        p.list(System.out);
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os Name", System.getProperty("os.name"));
        Reporter.setSystemInfo("os Version", System.getProperty("os.version"));
        Reporter.setTestRunnerOutput("Test runner output message");  
       
    }
	
	
	
}
