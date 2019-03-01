package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import stepDefinition.StepDefinition;

public class ExtentReport {

	
	public static ExtentReporter Instance()
    {
	ExtentReporter extent;
//String Path = "/Users/test/Desktop/temp/ExtentReport_" +  new Date().getTime()+".html";
String Path = "/Users/test/Desktop/temp/ExtentReport_" +  new SimpleDateFormat("yyyyMMdd_HHmmSSS").format(new Date())+".html";
System.out.println(Path);
extent = new ExtentHtmlReporter(Path);
return extent;
 }
	
	public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File("./output/scrernshots/");
        String dest = file.getPath()+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                    
        return dest;
    }
}
