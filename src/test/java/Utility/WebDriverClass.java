package Utility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import DataProvider.ConfigFileReader;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass {
    public static WebDriver driver=null;
    public WebDriver getDriver()
    {

        return this.driver;
    }
    public void setDriver(WebDriver driver)
    {
        this.driver=driver;
    }

    public void CreateWebDriver()
    {
    	ConfigFileReader configFileReader=new ConfigFileReader();
    	ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
        String chromelocation=System.getProperty("user.dir")+configFileReader.getDriverPath();
    	System.setProperty("webdriver.chrome.driver", chromelocation);
        driver = new ChromeDriver(option);
        driver.get(configFileReader.getURL());
    }

}