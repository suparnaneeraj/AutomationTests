package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import DataProvider.ConfigFileReader;

public class WebDriverClass extends ConfigFileReader {
	 public  WebDriver driver=null;
	
	public void CreateWebDriver()
	{
		try {
		String driverlocation=System.getProperty("user.dir")+getDriverPath();
		System.out.println(driverlocation);
		System.out.println(getBrowser());
		switch(getBrowser())
		{
		case "chrome": 
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
//      	WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver = new ChromeDriver(option);
			break;
		case "safari":
			driver=new SafariDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",driverlocation);
			driver = new FirefoxDriver();
			break;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void openApplication()
	{
		driver.get(getURL());
	}
	public WebDriver getDriver()
	{
		return this.driver;
	}
	public void setDriver(WebDriver driver)
	
	{
		this.driver=driver;
	}
	

}
