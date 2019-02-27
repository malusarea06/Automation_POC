package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

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
}
