package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	 private final String propertyFilePath= "Config//configuration.properties";
	 BufferedReader reader;
	 
	 public ConfigFileReader() throws IOException {
		File file = new File(".//Config//configuration.properties");
		 try {
			reader = new BufferedReader(new FileReader(file.getPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 properties = new Properties();
		 properties.load(reader);
		 reader.close();
		 
		 
	 }
	 
	 public String getDriverPath()
	 {
		String driverPath = properties.getProperty("driverPath");
		
		return driverPath;
		 
	 }
	 
	 
	 public String getAppUrlTeamEnv()
	 {
		 String url = properties.getProperty("url_TE");
		 System.out.println("URL : "+url);
		 return url;
	 }
	 
	 public String getAppUrlNightlyEnv()
	 {
		 String url = properties.getProperty("url_NG");
		 
		 return url;
	 }
}
