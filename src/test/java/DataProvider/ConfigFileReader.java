package DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private final String propertyFilePath= "configs//configuration.properties";
	BufferedReader reader;
	Properties properties;
	public ConfigFileReader() 
	{
		try {
			reader= new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			properties.load(reader);
			reader.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public String getDriverPath()
	{
		
		String driverPath=properties.getProperty("driverPath");
		if(driverPath!=null)
			return driverPath;
		else
			return "No driver path specified in properties file";
	}
	public String getURL()
	{
		
		String url=properties.getProperty("url");
		if(url!=null)
			return url;
		else
			return "No url  specified in properties file";
	}
	public String getBrowser()
	{
		String browser=properties.getProperty("browser");
		if(browser!=null)
			return browser;
		else
			return "browser not found in properties file";
	}
}
