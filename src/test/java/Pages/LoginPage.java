package Pages;
import org.openqa.selenium.WebDriver;


import Utility.GetWebElements;
public class LoginPage extends GetWebElements{
    private String errormessage;
    public String loginpagetitile,usernameField="user-name",passwordField="password",loginButton="login-button",loginPage="login_logo",loginError="//div[@class='error-message-container error']";
//  WebElement loginError ;;
//    @FindBy(id="user-name")
//    WebElement usernameField;
//    @FindBy(id="password")
//    WebElement passwordField;
//    @FindBy(id="login-button")
//    WebElement login;
//    @FindBy(className="login_logo")
//    WebElement loginPage;
//    @FindBy(xpath="//div[@class='error-message-container error']")
//    WebElement loginError ;
    
    

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginPageTitle() {
        loginpagetitile = getClassNameElement(loginPage).getText();
        return loginpagetitile;
    }

    public void EnterCredentials(String username, String password) {
    	getIdElement(usernameField).sendKeys(username);
    	getIdElement(passwordField).sendKeys(password);


    }

    public void Login() {
        getIdElement(loginButton).click();
    }

    public String getErrorMessage()
    {
        errormessage=getXpathElement(loginError).getText();
        return errormessage;
    }

}


