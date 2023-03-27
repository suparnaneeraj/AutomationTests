package Utility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    	ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
        String chromelocation=System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver";
    	System.setProperty("webdriver.chrome.driver", chromelocation);
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

}