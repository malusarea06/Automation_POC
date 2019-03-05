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

public class ExtentReport {

	
	public static String capture(WebDriver driver) 
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path =  System.getProperty("user.dir")+"/Screenshots/"+new SimpleDateFormat("yyyy_MM_dd__HHmmSSS").format(new Date())+".png";
        System.out.println("Path for png :"+path);
        File dest = new File(path);
        try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Capture Failed "+e.getMessage());
		}
         
        return dest.getPath();
    }
}
