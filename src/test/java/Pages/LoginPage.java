package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    protected WebDriver driver;
    private String errormessage;
    public String loginpagetitile;
    private By usernameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginBy = By.id("login-button");
    private By loginPage = By.className("login_logo");
    private By loginError = By.xpath("//div[@class='error-message-container error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle() {
        loginpagetitile = driver.getTitle();
        return loginpagetitile;
    }

    public void EnterCredentials(String username, String password) {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);


    }

    public void Login() {
        driver.findElement(loginBy).click();
    }

    public String getErrorMessage()
    {
        errormessage=driver.findElement(loginError).getText();
        return errormessage;
    }

}


